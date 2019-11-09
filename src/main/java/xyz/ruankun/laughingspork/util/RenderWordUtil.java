package xyz.ruankun.laughingspork.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

public class RenderWordUtil {

    //实习报告册模板路径
    public static final String REPORT_PATH = "word\\report.docx";
    //实习鉴定表模板路径
    public static final String IDENTIFY_PATH = "word\\identify.docx";

    /**
     * 渲染并导出word文档, 返回输出路径.
     *
     * @param renderWordType :  "report" or "identify"
     * @param params         :  渲染Word的参数
     * @return: java.lang.String
     */
    public static void exportWordToResponse(String renderWordType, String stuNo, Map<String, String> params, HttpServletResponse response) {
        Logger logger = LoggerFactory.getLogger(RenderWordUtil.class);
        WordUtil wordUtil = new WordUtil();
        XWPFDocument xwpfDocument;
        StringBuffer fileName = new StringBuffer(stuNo);
        try {
            if (renderWordType.equals("report")) {
                xwpfDocument = wordUtil.readXWPFDocumentFromFile(REPORT_PATH);
                fileName.append("_report.docx");
            } else {
                xwpfDocument = wordUtil.readXWPFDocumentFromFile(IDENTIFY_PATH);
                fileName.append("_identify.docx");
            }
            wordUtil.replaceInTable(xwpfDocument, params);
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName.toString());
            OutputStream out = response.getOutputStream();
            xwpfDocument.write(out);
            out.close();
            xwpfDocument.close();
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
