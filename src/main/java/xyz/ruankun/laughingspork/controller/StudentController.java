package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.WordUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/student")
@Api(tags = {"学生操作"})
@CrossOrigin
public class StudentController {

    @Autowired
    SxStudentService sxStudentService;

    @Autowired
    SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    SxReportService sxReportService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);


    @ApiOperation(value = "学生查看自己信息", httpMethod = "GET")
    @GetMapping("/selfInfo")
    @RequiresRoles("Student")
    public ResponseVO getSelfInfo() {
        return ControllerUtil.getDataResult((SxStudent) SecurityUtils.getSubject().getPrincipal());
    }

    @ApiOperation(value = "学生查看自己校内导师信息", httpMethod = "GET")
    @GetMapping("/teacher")
    @RequiresRoles("Student")
    public ResponseVO getTeacherInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getTeacherInfo(
                (SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }

    @ApiOperation(value = "学生查看自己报告册信息", httpMethod = "GET")
    @GetMapping("/report")
    @RequiresRoles("Student")
    public ResponseVO getSelfReportInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getSelfReportInfo(
                (SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }

    @ApiOperation(value = "学生查看鉴定表信息", httpMethod = "GET")
    @GetMapping("/identify")
    @RequiresRoles("Student")
    public ResponseVO getSelfIndentifyInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getSelfIndentifyInfo(
                (SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }


    @ApiOperation(value = "学生填写鉴定表信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "practiceContent", value = "实习内容", required = true),
            @ApiImplicitParam(name = "selfSummary", value = "自我总结", required = true),
    })
    @PostMapping("/identify")
    @RequiresRoles("Student")
    public ResponseVO fillIndentifyForm(String practiceContent, String selfSummary) {
        if (practiceContent == null || selfSummary == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            SxIdentifyForm sxIdentifyForm = sxStudentService.saveIndentifyForm
                    ((SxStudent) SecurityUtils.getSubject().getPrincipal(), practiceContent, selfSummary);
            if (sxIdentifyForm != null) {
                return ControllerUtil.getDataResult(sxIdentifyForm);
            } else {
                return ControllerUtil.getFalseResultMsgBySelf("未找到鉴定表");
            }
        }
    }

    @ApiOperation(value = "学生填写报告第一阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1_summary", value = "自我总结", required = true),
    })
    @PostMapping("/report/stage1")
    @RequiresRoles("Student")
    public ResponseVO stage1_summary(String stage1_summary) {
        if (stage1_summary == null || stage1_summary.isEmpty()) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            SxReport sxReport = sxStudentService.stage1_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage1_summary);
            if (sxReport != null) {
                return ControllerUtil.getDataResult(sxReport);
            } else {
                return ControllerUtil.getFalseResultMsgBySelf("未找到实习报告");
            }
        }
    }

    @ApiOperation(value = "学生填写报告第二阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage2_summary", value = "自我总结", required = true),
    })
    @PostMapping("/report/stage2")
    @RequiresRoles("Student")
    public ResponseVO stage2_summary(String stage2_summary) {
        if (stage2_summary == null || stage2_summary.isEmpty()) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            SxReport sxReport = sxStudentService.stage2_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage2_summary);
            if (sxReport != null) {
                return ControllerUtil.getDataResult(sxReport);
            } else {
                return ControllerUtil.getFalseResultMsgBySelf("未找到实习报告");
            }
        }
    }

    @ApiOperation(value = "下载学生实习鉴定表", httpMethod = "GET")
    @GetMapping("/identify/form")
    @RequiresRoles("Student")
    public void downloadIdentify(HttpServletRequest request, HttpServletResponse response) {
        try {
            SxStudent sxStudent = (SxStudent) SecurityUtils.getSubject().getPrincipal();
            logger.error(sxStudent.toString());
            SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIndentifyInfo(sxStudent.getStuNo());
            if (sxIdentifyForm != null) {
                Map<String, Object> params = new HashMap<>();
                params.put("stuName", sxStudent.getName());
                params.put("stuNo", sxStudent.getStuNo());
                params.put("college", sxStudent.getCollege());
                params.put("major", sxStudent.getMajor());
                params.put("corpName", sxStudent.getCorpName());
                params.put("content", sxIdentifyForm.getSxContent());
                params.put("selfSummary ", sxIdentifyForm.getSelfSummary());
                WordUtil.exportWord("word/identify.docx", "E:/temp",
                        "Identify_" + sxStudent.getStuNo() + ".docx", params, request, response);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }


    @ApiOperation(value = "下载学生实习报告册", httpMethod = "GET")
    @GetMapping("/report/form")
    @RequiresRoles("Student")
    public void downloadReport(HttpServletRequest request, HttpServletResponse response) {
        SxStudent sxStudent = (SxStudent) SecurityUtils.getSubject().getPrincipal();
        SxReport sxReport = sxReportService.getReportInfo(sxStudent.getStuNo());
        if (sxReport != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("stuName", sxStudent.getName());
            params.put("stuNo", sxStudent.getStuNo());
            params.put("college", sxStudent.getCollege());
            params.put("major", sxStudent.getMajor());
            params.put("corpName", sxStudent.getCorpName());
            params.put("corpPosition", sxStudent.getCorpPosition());
            params.put("stage1GuideDate ", sxReport.getStage1GuideDate());
            params.put("stage1GuideWay ", sxReport.getStage1GuideWay());
            params.put("stage1Summary ", sxReport.getStage1Summary());
            params.put("stage1Date", sxReport.getStage1Date());
            params.put("stage1Comment ", sxReport.getStage1Comment());
            params.put("stage1GradeDate", sxReport.getStage1GradeDate());
            params.put("stage1Grade", sxReport.getStage1Grade());
            params.put("stage2GuideDate ", sxReport.getStage2GuideDate());
            params.put("stage2GuideWay ", sxReport.getStage2GuideWay());
            params.put("stage2Summary ", sxReport.getStage2Summary());
            params.put("stage2Date", sxReport.getStage2Date());
            params.put("stage2Comment ", sxReport.getStage2Comment());
            params.put("stage2GradeDate", sxReport.getStage2GradeDate());
            params.put("stage2Grade", sxReport.getStage2Grade());
            WordUtil.exportWord("word/report.docx", "E:/temp",
                    "Report_" + sxStudent.getStuNo() + ".docx", params, request, response);
        }
    }
}

