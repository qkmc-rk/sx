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
import xyz.ruankun.laughingspork.entity.*;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.DateUtil;
import xyz.ruankun.laughingspork.util.RenderWordUtil;
import xyz.ruankun.laughingspork.util.WordUtilOld;
import xyz.ruankun.laughingspork.util.constant.RespCode;
import xyz.ruankun.laughingspork.util.constant.RoleCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping("/student")
@Api(tags = {"学生操作"})
public class StudentController {
    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    SxStudentService sxStudentService;

    @Autowired
    SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    SxReportService sxReportService;

    @Autowired
    SxTeacherService sxTeacherService;


    @ApiOperation(value = "返回当前报告册阶段信息", httpMethod = "GET")
    @GetMapping("/reportStage")
    public ResponseVO nowReportStage() {
        SxStagemanage sxStagemanage = sxStudentService.getNowReportStage();
        return ControllerUtil.getSuccessResultBySelf(sxStagemanage);

    }


    @ApiOperation(value = "学生查看自己信息", httpMethod = "GET")
    @RequiresRoles(RoleCode.STUDENT)
    @GetMapping("/selfInfo")
    public ResponseVO getSelfInfo() {
        return ControllerUtil.getDataResult((SxStudent) SecurityUtils.getSubject().getPrincipal());
    }

    @ApiOperation(value = "学生查看自己校内导师信息", httpMethod = "GET")
    @RequiresRoles(RoleCode.STUDENT)
    @GetMapping("/teacherInfo")
    public ResponseVO getTeacherInfo() {
        SxTeacher sxTeacher = sxStudentService.getTeacherInfo((SxStudent) SecurityUtils.getSubject().getPrincipal());
        if (sxTeacher == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(sxTeacher);
    }

    @ApiOperation(value = "学生查看自己报告册信息", httpMethod = "GET")
    @RequiresRoles(RoleCode.STUDENT)
    @GetMapping("/reportForm")
    public ResponseVO getSelfReportInfo() {
        SxReport sxReport = sxStudentService.getSelfReportInfo((SxStudent) SecurityUtils.getSubject().getPrincipal());
        if (sxReport == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(sxReport);
    }


    @ApiOperation(value = "学生查看鉴定表信息", httpMethod = "GET")
    @RequiresRoles(RoleCode.STUDENT)
    @GetMapping("/identifyForm")
    public ResponseVO getSelfIndentifyInfo() {
        SxIdentifyForm sxIdentifyForm = sxStudentService.getSelfIdentifyInfo((SxStudent) SecurityUtils.getSubject().getPrincipal());
        if (sxIdentifyForm == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(sxIdentifyForm);
    }


    @ApiOperation(value = "学生填写鉴定表信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "practiceContent", value = "实习内容", required = true),
            @ApiImplicitParam(name = "selfSummary", value = "自我总结", required = true),
    })
    @RequiresRoles(RoleCode.STUDENT)
    @PostMapping("/identify")
    public ResponseVO fillIdentifyForm(String practiceContent, String selfSummary) {
        if (practiceContent == null || selfSummary == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INCOMPLETE_DATA);
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.saveIdentifyForm((SxStudent) SecurityUtils.getSubject().getPrincipal(), practiceContent, selfSummary));
        }
    }

    @ApiOperation(value = "学生填写报告第一阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1_summary", value = "自我总结", required = true),
    })
    @RequiresRoles(RoleCode.STUDENT)
    @PostMapping("/report/stage1")
    public ResponseVO stage1_summary(@RequestParam String stage1_summary, @RequestParam String stage1GuideWay, @RequestParam String stage1GuideDate) {
        if (stage1_summary == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INCOMPLETE_DATA);
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage1_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage1_summary, stage1GuideWay, stage1GuideDate));
        }
    }

    @ApiOperation(value = "学生填写报告第二阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage2_summary", value = "自我总结", required = true),
    })
    @RequiresRoles(RoleCode.STUDENT)
    @PostMapping("/report/stage2")
    public ResponseVO stage2_summary(String stage2_summary, String stage2GuideWay, String stage2GuideDate) {
        if (stage2_summary == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INCOMPLETE_DATA);
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage2_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage2_summary, stage2GuideWay, stage2GuideDate));
        }
    }


    @ApiOperation(value = "下载学生实习鉴定表", httpMethod = "GET")
    @GetMapping("/identify/form")
    @RequiresRoles(RoleCode.STUDENT)
    public void downloadIdentify(HttpServletRequest request, HttpServletResponse response) {
        try {
            SxStudent sxStudent = (SxStudent) SecurityUtils.getSubject().getPrincipal();
            SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIdentifyInfo(sxStudent.getStuNo());
            if (sxIdentifyForm != null) {
                Map<String, Object> params = new HashMap<>();
                params.put("${stuName}", sxStudent.getName());
                params.put("${stuNo}", sxStudent.getStuNo());
                params.put("${college}", sxStudent.getCollege());
                params.put("${major}", sxStudent.getMajor());
                params.put("${corpName}", sxStudent.getCorpName());
                params.put("${content}", sxIdentifyForm.getSxContent());
                params.put("${selfSummary}", sxIdentifyForm.getSelfSummary());
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }


    @ApiOperation(value = "下载学生实习报告册", httpMethod = "GET")
    @GetMapping("/report/form")
    @RequiresRoles(RoleCode.STUDENT)
    public void downloadReport(HttpServletRequest request, HttpServletResponse response) {
        SxStudent sxStudent = (SxStudent) SecurityUtils.getSubject().getPrincipal();
        SxReport sxReport = sxReportService.getReportInfo(sxStudent.getStuNo());
        SxTeacher sxTeacher = sxTeacherService.findByTeacherNo(sxStudent.getTeacherNo());
        if (sxReport != null) {
            Map<String, String> params = new HashMap<>();
            params.put("${stu_name}", sxStudent.getName());
            params.put("${stu_no}", sxStudent.getStuNo());
            params.put("${college}", sxStudent.getCollege());
            params.put("${major}", sxStudent.getMajor());
            params.put("${corp_name}", sxStudent.getCorpName());
            params.put("${corp_position}", sxStudent.getCorpPosition());
            params.put("${stage1_guide_date}", sxReport.getStage1GuideDate());
            params.put("${stage1_guide_way}", sxReport.getStage1GuideWay());
            params.put("${stage1_summary}", sxReport.getStage1Summary());
            params.put("${stage1_comment}", sxReport.getStage1Comment());
            params.put("${stage1_grade}", sxReport.getStage1Grade());
            params.put("${stage2_guide_date}", sxReport.getStage2GuideDate());
            params.put("${stage2_guide_way}", sxReport.getStage2GuideWay());
            params.put("${stage2_summary}", sxReport.getStage2Summary());
            params.put("${stage2_comment}", sxReport.getStage2Comment());
            params.put("${stage2_grade}", sxReport.getStage2Grade());
            params.put("${teacher}", sxTeacher.getName());
            params.put("${total_grade}", sxReport.getTotalGrade());
            params.put("${total_score}", sxReport.getTotalScore());
            params.put("${gmt_start}", DateUtil.DateToCnDateStr(sxReport.getGmtStart()));
            params.put("${gmt_end}", DateUtil.DateToCnDateStr(sxReport.getGmtEnd()));
            params.put("${fill_date}", DateUtil.getCnDateStr());
            RenderWordUtil.exportWordToResponse("report", sxStudent.getStuNo(), params, response);
        }
    }
}
