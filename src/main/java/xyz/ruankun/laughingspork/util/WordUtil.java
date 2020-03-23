package xyz.ruankun.laughingspork.util;

import org.apache.poi.xwpf.usermodel.*;
import org.jodconverter.DocumentConverter;
import org.jodconverter.office.OfficeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 这是一个用于处理 word docx中<b>表格</b>的工具类，主要提供：
 * 1.加载word模板
 * 2.将内容填上word表格内容中
 * 3.导出word文件
 * <b style="color:red;">注意：使用该工具类需要明白导入的模板文件需要具备什么样的格式，因为这个实用性
 * 做的不是很好，所以一定要按照固定套路来。模板注意事项请参照./Readme.java</b>
 *
 * @author ruan
 */
public class WordUtil {

    public static final Logger logger = LoggerFactory.getLogger(WordUtil.class);

    // @Autowired
    // DocumentConverter documentConverter;

    /**
     * 通过路径读入word模板文件
     *
     * @param path word模板文件存储的位置
     * @return 返回WXPFDocument对象
     * @throws IOException 流异常/xwpf异常
     */
    public XWPFDocument readXWPFDocumentFromFile(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        InputStream inputStream = resource.getInputStream();
        XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
        close(inputStream);
        return xwpfDocument;
    }

    /**
     * 替换段落里面的变量 变量形式： ${variable}
     *
     * @param para   传入一个段落
     * @param params 传入变量以及变量的值
     */
    private void replaceInPara(XWPFParagraph para, Map<String, String> params) {
        if (this.matcher(para.getParagraphText()).find()) {
            // 将paragraph中的变量内容替换成变量的值，然后在换回去
            Set<String> keys = params.keySet();
            String content = para.getParagraphText();
            StringBuilder contentRs;
            for (String k : keys) {
                // 包含子串
                if (para.getParagraphText().indexOf(k) != -1) {

                    // 在删除旧的run之前需要将带有daoler符号的那个run的格式全部记录下来。
                    List<XWPFRun> runs = para.getRuns();

                    // 初始化需要保存的变量
                    int textPosition = 0;
                    int fontSize = 0;
                    String fontFamily = "";
                    // 使用会抛出异常
                    // int    characterSpacing = 0;
                    String color = "";
                    int kerning = 0;
                    UnderlinePatterns underline = null;
                    VerticalAlign subscript = null;

                    for (XWPFRun run :
                            runs) {
                        // $符号是变量起始位置的符号,这个$符的格式就是变量在word中的格式
                        if (-1 != run.text().indexOf("$")) {
                            textPosition = run.getTextPosition();
                            fontSize = run.getFontSize();
                            fontFamily = run.getFontFamily();
                            // characterSpacing = run.getCharacterSpacing(); //使用会抛出异常
                            color = run.getColor();
                            kerning = run.getKerning();
                            underline = run.getUnderline();
                            subscript = run.getSubscript();
                        }
                    }
                    // 设置新的run之前删除旧的run
                    int size = para.getRuns().size();
                    while (size > 0) {
                        para.removeRun(0);
                        size = para.getRuns().size();
                    }
                    para.removeRun(0);  //这一句是多余的吧?既生之,何弃之.

                    // 设置新的run
                    int start = content.indexOf(k);
                    int end = start + k.length();
                    contentRs = new StringBuilder();
                    contentRs.append(content.substring(0, start));
                    contentRs.append(params.get(k));
                    contentRs.append(content.substring(end));
                    para.insertNewRun(0).setText(contentRs.toString());

                    // 设置para的run的格式等内容
                    para.getRuns().get(0).setFontFamily(fontFamily);
                    para.getRuns().get(0).setFontSize(fontSize);
                    // para.getRuns().get(0).setCharacterSpacing(characterSpacing);//使用会抛出异常
                    para.getRuns().get(0).setColor(color);
                    para.getRuns().get(0).setUnderline(underline);
                    para.getRuns().get(0).setTextPosition(textPosition);
                    para.getRuns().get(0).setKerning(kerning);
                    para.getRuns().get(0).setSubscript(subscript);
                }
            }
        }
    }

    /**
     *
     * 替换表格里面的变量 ${variable}
     * @param doc
     * @param params
     *
     */
    public void replaceInTable(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * 将word docx文件保存到本地文件中
     * @param docx     当前编辑的docx文件
     * @param fileName 要保存的docx文件的名字,不包括后缀<b>.docx</b>
     * @param path
     */
    public String printToFile(XWPFDocument docx, String fileName, String path) {
        if(SystemUtil.isWindows()){
            path = System.getProperty("user.dir") + "\\" + path;
        }else {
            path = System.getProperty("user.dir") + "/" + path;
        }

        fileName += ".docx";
        try {
            File file = new File(path + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            docx.write(outputStream);
            close(outputStream);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 正则表达式 匹配形如 ${userName} 的表达式
     * @param str 字符串
     * @return 返回 Matcher 对象
     */
    private Matcher matcher(String str) {
        String regStr = "\\$\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    public void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}