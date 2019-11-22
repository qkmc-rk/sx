package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.*;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.*;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.EntityUtil;
import xyz.ruankun.laughingspork.util.constant.RespCode;
import xyz.ruankun.laughingspork.util.constant.RoleCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;
import org.apache.shiro.SecurityUtils;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/teacher")
@Api(tags = {"校内导师操作"})
public class TeacherController {
    @Autowired
    private SxReportService sxReportService;

    @Autowired
    private SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    private SxTeacherService sxTeacherService;

    @Autowired
    private SxStudentService sxStudentService;

    public static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @ApiOperation(value = "教师获取所有指导的学生", httpMethod = "GET")

    @RequiresRoles(RoleCode.TEACHER)
    @GetMapping("/students")
    public ResponseVO getStudentList() {
        List<SxStudent> sxStudents = sxTeacherService.getStudentListByTeacherNo((SxTeacher) SecurityUtils.getSubject().getPrincipal());
        if (sxStudents.isEmpty()) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        } else {
            for (SxStudent s : sxStudents
            ) {
                sxTeacherService.isIdentifyFilledFlag(s);
                sxTeacherService.isReportFilledFlag(s);
                sxTeacherService.isIdentifyFlag(s);
                sxTeacherService.isReportFlag(s);
                s.setPassword(null);
            }

            return ControllerUtil.getSuccessResultBySelf(sxStudents);
        }
    }

    @ApiOperation(value = "教师根据根据学生学号获取对应学生信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true)
    })
    @GetMapping("/student/{stuNo}")
    @RequiresRoles(RoleCode.TEACHER)
    public ResponseVO getStudentInfo(@PathVariable String stuNo) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if (!sxStudentService.testAuth(tNo, stuNo)) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
        }
        SxStudent sxStudent = sxStudentService.findByStuNo(stuNo);
        if (sxStudent == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        sxStudent.setPassword(null);
        return ControllerUtil.getDataResult(sxStudent);
    }


    @ApiOperation(value = "根据学生学号查找对应报告册", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true)
    })
    @RequiresRoles(RoleCode.TEACHER)
    @GetMapping("/student/report/{stuNo}")
    public ResponseVO getReportInfo(@PathVariable String stuNo) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if (!sxStudentService.testAuth(tNo, stuNo)) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
        }

        SxReport sxReport = sxReportService.getReportInfo(stuNo);
        if (sxReport == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(sxReport);
    }

    @ApiOperation(value = "根据学生学号查找对应鉴定表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true)
    })
    @RequiresRoles(RoleCode.TEACHER)
    @GetMapping("/student/identify/{stuNo}")
    public ResponseVO getIdentifyInfo(@PathVariable String stuNo) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if (!sxStudentService.testAuth(tNo, stuNo)) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
        }
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIdentifyInfo(stuNo);
        if (sxIdentifyForm == null) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_NOT_FOUND_DATA);
        }
        return ControllerUtil.getDataResult(sxIdentifyForm);
    }

    @ApiOperation(value = "教师根据根据学生学号修改学生报告册阶段1信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学号", required = true),
            @ApiImplicitParam(name = "stage1_comment", value = "阶段一教师评语", required = true),
            @ApiImplicitParam(name = "stage1_grade", value = "阶段一教师成绩评定", required = true),
    })
    @RequiresRoles(RoleCode.TEACHER)
    @PostMapping("student/reportStage1/{stuNo}")
    public ResponseVO operateReport1(@PathVariable String stuNo, String stage1_comment, String stage1_grade) {
        SxReport sxReport = sxTeacherService.saveReport1(stuNo, stage1_comment, stage1_grade);
        return ControllerUtil.getDataResult(sxReport);

    }

    @ApiOperation(value = "教师根据根据学生学号修改学生报告册阶段2信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学号", required = true),
            @ApiImplicitParam(name = "stage2_comment", value = "阶段二教师评语", required = true),
            @ApiImplicitParam(name = "stage2_grade", value = "阶段二教师成绩评定", required = true),
    })
    @RequiresRoles(RoleCode.TEACHER)
    @PostMapping("student/reportStage2/{stuNo}")
    public ResponseVO operateReport2(@PathVariable String stuNo, String stage2_comment, String stage2_grade) {
        SxReport sxReport = sxTeacherService.saveReport2(stuNo, stage2_comment, stage2_grade);
        return ControllerUtil.getDataResult(sxReport);
    }


    @ApiOperation(value = "学院教师填写完善学生鉴定表", httpMethod = "POST")
    @RequiresRoles(RoleCode.TEACHER)
    @PostMapping("/student/identifyForm")
    public ResponseVO operateIdentifyForm(SxIdentifyForm sxIdentifyForm) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        String sNo = sxIdentifyForm.getStuNo();
        if (sxStudentService.testAuth(tNo, sNo)) {
            SxIdentifyForm oldSxIdentifyForm = sxIdentifyFormService.getIdentifyInfo(sNo);
            EntityUtil.update(sxIdentifyForm, oldSxIdentifyForm);
            sxIdentifyFormService.saveIdentifyForm(sxIdentifyForm);
            return ControllerUtil.getDataResult(sxIdentifyFormService.getIdentifyInfo(sNo));
        } else {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
        }
    }

    @ApiOperation(value = "学院教师填写完善学生报告册", httpMethod = "POST")
    @RequiresRoles(RoleCode.TEACHER)
    @PostMapping("/student/reportForm")
    public ResponseVO operateReportForm(SxReport sxReport) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        String sNo = sxReport.getStuNo();
        if (sxStudentService.testAuth(tNo, sNo)) {
            SxReport OldSxReport = sxReportService.getReportInfo(sNo);
            EntityUtil.update(sxReport, OldSxReport);
            sxReportService.saveReport(sxReport);
            return ControllerUtil.getDataResult(sxReportService.getReportInfo(sNo));
        } else {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
        }
    }

}

