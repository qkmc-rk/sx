package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxCorpTeacherService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

/**
 * 校外导师控制器
 * @author lck
 */
@RestController
@RequestMapping("/corpteacher")
public class CorpTeacherController {

    @Autowired
    private SxCorpTeacherService sxCorpTeacherService;
    @ApiOperation(value = "查看所有学生",httpMethod = "GET")
    @GetMapping("/getAllStu")
    public ResponseVO getStudentsList() {
        return ControllerUtil.getDataResult(sxCorpTeacherService.getOwnedStudentsList(new SxCorpTeacher()));//模拟已登录的CorpTeacher
    }
    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/getStuIdentifyForm")
    public ResponseVO getStuIdentifyForm(String stuNo){
        return ControllerUtil.getDataResult(sxCorpTeacherService.getIdentifyFormByStuId(stuNo));
    }
    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query"),
            @ApiImplicitParam(name = "teacherOpinion",value = "校外导师意见",required = true,paramType = "query"),
            @ApiImplicitParam(name = "teacherScore",value = "校外导师打分",required = true,paramType = "query"),
            @ApiImplicitParam(name = "teacherGrade",value = "校外导师成绩评定",required = true,paramType = "query")
    })
    @GetMapping("/operateIdentifyForm")
    public ResponseVO operateIdentifyForm(String stuNo,String teacherOpinion, String teacherScore,String teacherGrade){//前端传入校外导师的意见，打分，评定等级
        return ControllerUtil.getDataResult(sxCorpTeacherService.operateIdentifyForm(stuNo,teacherOpinion,teacherScore,teacherGrade));
    }
}
