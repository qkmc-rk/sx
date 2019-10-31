package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;
import org.apache.shiro.SecurityUtils;


import java.util.List;
/**
 * 校内老师
 * @return:
 */
@RestController
@RequestMapping("/teacher")
@Api(tags = {"校内导师操作"})
public class TeacherController {

    @Autowired
    private SxStudentService sxStudentService;

    @Autowired
    private SxReportService sxReportService;

    @Autowired
    private SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    private SxTeacherService sxTeacherService;

    @ApiOperation(value = "教师根据根据学生学号获取对应学生信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/students")
    public ResponseVO getStudentList(){
       List<SxStudent> sxStudents = sxTeacherService.getStudentListByTeacherNo((SxTeacher) SecurityUtils.getSubject().getPrincipal());
        if (sxStudents.isEmpty()){
            return ControllerUtil.getFalseResultMsgBySelf("没有找到相关信息");
        }
        else {
            return ControllerUtil.getSuccessResultBySelf(sxStudents);
        }
    }


    @ApiOperation(value = "根据学生学号查找对应报告表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/students/report/{stuNo}")
    private ResponseVO getReportInfo(@PathVariable("stuNo") String stuNO){
        SxReport sxReport = sxReportService.getReportInfo(stuNO);
        if (sxReport == null){
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxReport);
    }

    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/students/indentify/{stuNo}")
    public ResponseVO getIdentifyInfo(@PathVariable("stuNo") String stuNO){
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIndentifyInfo(stuNO);
        if (sxIdentifyForm == null){
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxIdentifyForm);
    }

    @ApiOperation(value = "校内教师填写鉴定表意见",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "opinion",value = "校内教师意见",required = true,paramType = "path"),
            @ApiImplicitParam(name = "score",value = "校内教师打分",required = true,paramType = "path")
    })
    @PostMapping("/students/indentify/{stuNo}")
    public ResponseVO fillIndentifyAdvice(@PathVariable("stuNo") String stuNo,@RequestParam String score){
        return ControllerUtil.getDataResult(sxTeacherService.fillIndentifyAdvice(stuNo,score));
    }
}
