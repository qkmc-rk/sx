package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.service.SxTeacherService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.util.List;


/**
 * 校内老师
 * @return:
 */


@RestController
@RequestMapping("/teacher")
public class TeacherController<ApiOperation> {

    @Autowired
    private SxStudentService sxStudentService;

    @Autowired
    private SxReportService sxReportService;

    @Autowired
    private SxIdentifyFormService sxIdentifyFormService;

    @Autowired
    private SxTeacherService sxTeacherService;


    @io.swagger.annotations.ApiOperation(value = "教师根据根据学生学号获取对应学生信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/studentList")
    public ResponseVO getStudentList(String stuNo){
        List<SxStudent> sxStudents = sxStudentService.getByTeacherNo(stuNo);
        if (sxStudents == null){
            return ControllerUtil.getFalseResultMsgBySelf("没有找到相关信息");
        }
        else {
            return ControllerUtil.getSuccessResultBySelf(sxStudents);
        }
    }


    @io.swagger.annotations.ApiOperation(value = "根据学生学号查找对应报告表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/reportInfo")
    private ResponseVO getReportInfo(String stuNo){
        SxReport sxReport = sxReportService.getReportInfo(stuNo);
        if (sxReport == null){
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxReport);
    }

    @io.swagger.annotations.ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/identifyInfo")
    public ResponseVO getIdentifyInfo(String stuNO){
        SxIdentifyForm sxIdentifyForm = sxIdentifyFormService.getIndentifyInfo(stuNO);
        if (sxIdentifyForm == null){
            return ControllerUtil.getFalseResultMsgBySelf("无相关信息");
        }
        return ControllerUtil.getDataResult(sxIdentifyForm);
    }

    @io.swagger.annotations.ApiOperation(value = "校内教师填写鉴定表意见",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "CTOpnion",value = "校内教师意见",required = true,paramType = "query"),
            @ApiImplicitParam(name = "CTScore",value = "校内教师打分",required = true,paramType = "query")
    })
    @GetMapping("/fillIndentifyAdvice")
    public ResponseVO fillIndentifyAdvice(SxStudent sxStudent, @RequestParam String CTOpnion,@RequestParam String CTScore){
        return ControllerUtil.getDataResult(sxTeacherService.fillIndentifyAdvice(new SxStudent(),CTOpnion,CTScore));
    }
}
