package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.util.List;

/**
 * 学院领导小组控制器
 *
 * @author lck
 */
@RestController
@RequestMapping("/collegeprincipal")
@Api(tags = "学院领导小组操作")
public class CollegePrincipalController {
    @Autowired
    private SxCollegePrincipalService sxCollegePrincipalService;

    @ApiOperation(value = "查看所有学生", httpMethod = "GET")
    @GetMapping("/student")
    public ResponseVO getOwnedStudentsList() {
        SxCollegePrincipal sxCollegePrincipal = (SxCollegePrincipal) SecurityUtils.getSubject().getPrincipal();
        if (sxCollegePrincipal == null) {
            return ControllerUtil.getFalseResultMsgBySelf("未登录，请重新登录");
        }
        List<SxStudent> list = sxCollegePrincipalService.getOwnedStudentsList(sxCollegePrincipal);
        if (list == null) {
            return ControllerUtil.getFalseResultMsgBySelf("学生列表为空");
        }
        return ControllerUtil.getDataResult(list);
    }

    @ApiOperation(value = "根据学生学号查找对应鉴定表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true)
    })
    @GetMapping("/identifyForm/student/{stuNo}")
    public ResponseVO getIdentifyFormByStuId(String stuNo) {
        SxIdentifyForm form = sxCollegePrincipalService.getIdentifyFormByStuId(stuNo);
        if (form == null) {
            return ControllerUtil.getFalseResultMsgBySelf("未找到学号为" + stuNo + "的学生鉴定表");
        }
        return ControllerUtil.getDataResult(form);
    }

    @ApiOperation(value = "给鉴定表写建议打分", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo", value = "学生学号", required = true),
            @ApiImplicitParam(name = "collegePrincipalOpinion", value = "学院负责人建议", required = true),
            @ApiImplicitParam(name = "comprehsvGrade", value = "综合评定成绩", required = true),
    })
    @PostMapping("/identifyForm")
    public ResponseVO operateIdentifyForm(String stuNo, String collegePrincipalOpinion, String comprehsvGrade) {
        SxIdentifyForm form = sxCollegePrincipalService.operateIdentifyForm(stuNo, collegePrincipalOpinion, comprehsvGrade);
        if (collegePrincipalOpinion == null || comprehsvGrade == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完所有内容");
        }
        return ControllerUtil.getDataResult(form);
    }
}
