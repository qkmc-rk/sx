package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.util.List;

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
        SxCollegePrincipal sxCollegePrincipal= (SxCollegePrincipal) SecurityUtils.getSubject().getPrincipal();
        if(sxCollegePrincipal==null){
            return ControllerUtil.getFalseResultMsgBySelf("未登录，请重新登录");
        }
        List<SxStudent> list=sxCollegePrincipalService.getOwnedStudentsList(sxCollegePrincipal);
        if(list == null){
            return ControllerUtil.getFalseResultMsgBySelf("学生列表为空");
        }
        return ControllerUtil.getDataResult(list);
    }
    @ApiOperation(value = "根据学生学号查找对应鉴定表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query")
    })
    @GetMapping("/getIdentifyForm")
    public ResponseVO getIdentifyFormByStuId(String stuNo){
        SxIdentifyForm form=sxCollegePrincipalService.getIdentifyFormByStuId(stuNo);
        if(form == null){
            return ControllerUtil.getFalseResultMsgBySelf("未找到学号为"+stuNo+"的学生鉴定表");
        }
        return ControllerUtil.getDataResult(form);
    }
    @ApiOperation(value = "给鉴定表写建议打分",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号",required = true,paramType = "query"),
            @ApiImplicitParam(name = "collegePrincipalOpinion",value = "学院负责人建议",required = true,paramType = "query"),
            @ApiImplicitParam(name = "comprehsvGrade",value = "综合评定成绩",required = true,paramType = "query"),
    })
    @GetMapping("/operateIdentifyForm")
    public ResponseVO operateIdentifyForm(String stuNo, @RequestParam String collegePrincipalOpinion,@RequestParam String comprehsvGrade){
        SxIdentifyForm form=sxCollegePrincipalService.operateIdentifyForm(stuNo,collegePrincipalOpinion,comprehsvGrade);
        if(collegePrincipalOpinion==null || comprehsvGrade==null){
            return ControllerUtil.getFalseResultMsgBySelf("请填写完所有内容");
        }
        return ControllerUtil.getDataResult(form);
    }
}
