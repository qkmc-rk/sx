package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

/**
 * 学院领导小组控制器
 * @author lck
 */
@RestController
@RequestMapping("/collegeprincipal")
public class CollegePrincipalController {
    @Autowired
    private SxCollegePrincipalService sxCollegePrincipalService;
    @ApiOperation(value = "查看所有学生",httpMethod = "GET")
    @GetMapping("/getAllStu")
    public ResponseVO getOwnedStudentsList(){
        return ControllerUtil.getDataResult(sxCollegePrincipalService.getOwnedStudentsList(new SxCollegePrincipal()));
    }
    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/getIdentifyForm")
    public ResponseVO getIdentifyFormByStuId(String stuNo){
        return ControllerUtil.getDataResult(sxCollegePrincipalService.getIdentifyFormByStuId(stuNo));
    }
    @ApiOperation(value = "给鉴定表写建议打分",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query"),
            @ApiImplicitParam(name = "collegePrincipalOpinion",value = "学院负责人建议",required = true,paramType = "query"),
            @ApiImplicitParam(name = "comprehsvGrade",value = "综合评定成绩",required = true,paramType = "query"),
    })
    @GetMapping("/operateIdentifyForm")
    public ResponseVO operateIdentifyForm(String stuNo,String collegePrincipalOpinion, String comprehsvGrade){
        return ControllerUtil.getDataResult(sxCollegePrincipalService.operateIdentifyForm(stuNo,collegePrincipalOpinion,comprehsvGrade));
    }
}
