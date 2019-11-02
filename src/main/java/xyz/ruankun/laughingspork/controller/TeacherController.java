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
import xyz.ruankun.laughingspork.service.*;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.constant.RespCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;
import org.apache.shiro.SecurityUtils;


import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * 校内老师
 *
 * @return:
 */
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

    @ApiOperation(value = "教师根据根据学生学号获取对应学生列表信息", httpMethod = "GET")

//    @RequiresRoles("Teacher")
    @GetMapping("/students")
    public ResponseVO getStudentList() {
        List<SxStudent> sxStudents = sxTeacherService.getStudentListByTeacherNo((SxTeacher) SecurityUtils.getSubject().getPrincipal());
        if (sxStudents.isEmpty()) {
            return ControllerUtil.getFalseResultMsgBySelf("没有找到相关信息");
        } else {
            return ControllerUtil.getSuccessResultBySelf(sxStudents);
        }
    }

    @ApiOperation(value = "教师根据根据学生学号获取对应学生信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true, paramType = "query")
    })
    @GetMapping("/student/{stuNo}")
    public ResponseVO getStudentInfo(@PathVariable String stuNo){
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if(!sxStudentService.testAuth(tNo,stuNo)){
            return ControllerUtil.getFalseResultMsgBySelf("您没有权限");
        }
        SxStudent sxStudent = sxStudentService.findByStuNo(stuNo);
        if (sxStudent == null){
            return ControllerUtil.getFalseResultMsgBySelf("没有找到"+stuNo+"学生的信息");
        }
        return ControllerUtil.getDataResult(sxStudent);
    }



    @ApiOperation(value = "根据学生学号查找对应报告表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true, paramType = "path")
    })
//    @RequiresRoles("Teacher")
    @GetMapping("/student/report/{stuNo}")
    private ResponseVO getReportInfo(@PathVariable("stuNo") String stuNO) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if(!sxStudentService.testAuth(tNo,stuNO)){
            return ControllerUtil.getFalseResultMsgBySelf("您没有权限");
        }

        SxReport sxReport = sxReportService.getReportInfo(stuNO);
        if (sxReport == null) {
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxReport);
    }

    @ApiOperation(value = "根据学生学号查找对应鉴定表", httpMethod = "get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true, paramType = "query")
    })
//    @RequiresRoles("Teacher")
    @GetMapping("/student/identify/{stuNo}")
    public ResponseVO getIdentifyInfo(@PathVariable("stuNo") String stuNO) {

        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        String tNo = sxTeacher.getTeacherNo();
        if(!sxStudentService.testAuth(tNo,stuNO)){
            return ControllerUtil.getFalseResultMsgBySelf("您没有权限");
        }
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIdentifyInfo(stuNO);
        if (sxIdentifyForm == null) {
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxIdentifyForm);
    }

    @ApiOperation(value = "教师根据根据学生学号修改学生报告册阶段1信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学号", required = true),
            @ApiImplicitParam(name = "stage1_comment", value = "阶段一教师评语", required = true),
            @ApiImplicitParam(name = "stage1_grade", value = "阶段一教师成绩评定", required = true),
    })
//    @RequiresRoles("Teacher")
    @PostMapping("student/reportStage1/{stuNo}")
    public ResponseVO operateReport1(@PathVariable String stuNo, String stage1_comment, String stage1_grade) {
        if (stuNo == null || stage1_comment == null || stage1_grade == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完所有信息");
        } else {
            SxReport sxReport = sxTeacherService.saveReport1(stuNo, stage1_comment, stage1_grade);
            return ControllerUtil.getDataResult(sxReport);
        }
    }

    @ApiOperation(value = "教师根据根据学生学号修改学生报告册阶段2信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学号", required = true),
            @ApiImplicitParam(name = "stage2_comment", value = "阶段二教师评语", required = true),
            @ApiImplicitParam(name = "stage2_grade", value = "阶段二教师成绩评定", required = true),
    })
//    @RequiresRoles("Teacher")
    @PostMapping("student/reportStage2/{stuNo}")
    public ResponseVO operateReport2(@PathVariable String stuNo, String stage2_comment, String stage2_grade) {
        if (stuNo == null || stage2_comment == null || stage2_grade == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完所有信息");
        } else {
            SxReport sxReport = sxTeacherService.saveReport2(stuNo, stage2_comment, stage2_grade);
            return ControllerUtil.getDataResult(sxReport);
        }
    }


    @ApiOperation(value = "学院教师填写完善学生鉴定表", httpMethod = "POST")
//    @RequiresRoles("Teacher")
    @PostMapping("/student/identifyForm")
    public ResponseVO operateIdentifyForm(SxIdentifyForm sxIdentifyForm) {
        SxTeacher sxTeacher = (SxTeacher) SecurityUtils.getSubject().getPrincipal();
        List<SxStudent> sxStudents = sxTeacherService.getStudentListByTeacherNo(sxTeacher);
        String sNo = sxIdentifyForm.getStuNo();
        for (SxStudent s : sxStudents
        ) {
            if (sNo.equals(s.getStuNo())) {
                sxIdentifyFormService.saveIdentifyForm(sxIdentifyForm);
                return ControllerUtil.getDataResult(sxIdentifyFormService.getIdentifyInfo(sNo));
            }
        }
        return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_INVALID_OPERATION);
    }
}

