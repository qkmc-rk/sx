package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxCorp;
import xyz.ruankun.laughingspork.service.SxCorpService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

/**
 * 实习单位控制器
 * @author lck
 */
@RestController
@RequestMapping("/corp")
public class CorpController {
    @Autowired
    private SxCorpService sxCorpService;
    @ApiOperation(value = "查看所有学生",httpMethod = "GET")
    @GetMapping("/getAllStu")
    public ResponseVO getOwnedStudentsList(){
        return ControllerUtil.getDataResult(sxCorpService.getOwnedStudentsList(new SxCorp()));
    }
    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/getIdentifyForm")
    public ResponseVO getIdentifyFormByStuId(String stuNo){
        return ControllerUtil.getDataResult(sxCorpService.getIdentifyFormByStuId(stuNo));
    }
    @ApiOperation(value = "单位负责人填写鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query"),
            @ApiImplicitParam(name = "corpOpinion",value = "单位负责人建议",required = true,paramType = "query")
    })
    @GetMapping("/operateIdentifyForm")
    public ResponseVO operateIdentifyForm(String stuNo, String corpOpinion){
        return ControllerUtil.getDataResult(sxCorpService.operateIdentifyForm(stuNo,corpOpinion));
    }
}
