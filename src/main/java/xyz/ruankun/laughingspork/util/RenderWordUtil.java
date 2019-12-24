package xyz.ruankun.laughingspork.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RenderWordUtil {

    private static Logger logger = LoggerFactory.getLogger(RenderWordUtil.class);

    // windows下的路径
    // 实习报告册模板路径
    public static String REPORT_PATH = SystemUtil.isWindows()?"word\\report.docx":"word/report.docx";
    // 实习鉴定表模板路径
    public static String IDENTIFY_PATH = SystemUtil.isWindows()?"word\\identify.docx":"word/identify.docx";

    public static String BASE_SAVE_PATH = SystemUtil.isWindows()?"static\\":"static/";

    /**
     * 渲染并导出word文档, 返回输出路径.
     *
     * @param renderWordType :  "report" or "identify"
     * @param params         :  渲染Word的参数
     * @return: java.lang.String
     */
    public static String exportWordToResponse(String renderWordType, String stuNo, Map<String, String> params) {
        Logger logger = LoggerFactory.getLogger(RenderWordUtil.class);
        WordUtil wordUtil = new WordUtil();
        XWPFDocument xwpfDocument;
        StringBuffer fileName = new StringBuffer(stuNo);

        try {
            if (renderWordType.equals("report")) {
                xwpfDocument = wordUtil.readXWPFDocumentFromFile(REPORT_PATH);
                fileName.append("_report_");
            } else {
                xwpfDocument = wordUtil.readXWPFDocumentFromFile(IDENTIFY_PATH);
                fileName.append("_identify_");
            }
            fileName.append(System.currentTimeMillis());
            wordUtil.replaceInTable(xwpfDocument, params);
            String savePath = wordUtil.printToFile(xwpfDocument, fileName.toString(), BASE_SAVE_PATH);
            if (savePath != null) {
                return savePath;
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
}
