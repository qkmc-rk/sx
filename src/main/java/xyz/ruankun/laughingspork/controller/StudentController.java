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
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.io.Serializable;


@RestController
@CrossOrigin
@RequestMapping("/student")
@Api(tags = {"学生操作"})
public class StudentController {

    @Autowired
    SxStudentService sxStudentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);


    @ApiOperation(value = "学生查看自己信息", httpMethod = "GET")
    @GetMapping("/selfInfo")
    public ResponseVO getSelfInfo() {
        return ControllerUtil.getDataResult((SxStudent) SecurityUtils.getSubject().getPrincipal());
    }

    @ApiOperation(value = "学生查看自己校内导师信息", httpMethod = "GET")
    @GetMapping("/teacher")
    public ResponseVO getTeacherInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getTeacherInfo((SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }

    @ApiOperation(value = "学生查看自己报告册信息", httpMethod = "GET")
    @GetMapping("/report")
    public ResponseVO getSelfReportInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getSelfReportInfo((SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }

    @ApiOperation(value = "学生查看鉴定表信息", httpMethod = "GET")
    @GetMapping("/identify")
    public ResponseVO getSelfIndentifyInfo() {
        return ControllerUtil.getDataResult(sxStudentService.getSelfIndentifyInfo((SxStudent) SecurityUtils.getSubject().getPrincipal()));
    }


    @ApiOperation(value = "学生填写鉴定表信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "practiceContent", value = "实习内容", required = true),
            @ApiImplicitParam(name = "selfSummary", value = "自我总结", required = true),
    })
    @PostMapping("/identify")
    public ResponseVO fillIndentifyForm(@RequestParam String practiceContent, @RequestParam String selfSummary) {
        if (practiceContent == null || selfSummary == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.saveIndentifyForm((SxStudent) SecurityUtils.getSubject().getPrincipal(), practiceContent, selfSummary));
        }
    }

    @ApiOperation(value = "学生填写报告第一阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1_summary", value = "自我总结", required = true),
    })
    @PostMapping("/report/stage1")
    public ResponseVO stage1_summary(@RequestParam String stage1_summary) {
        if (stage1_summary == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage1_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage1_summary));
        }
    }

    @ApiOperation(value = "学生填写报告第二阶段信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage2_summary", value = "自我总结", required = true),
    })
    @PostMapping("/report/stage2")
    public ResponseVO stage2_summary(@RequestParam String stage2_summary) {
        if (stage2_summary == null) {
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        } else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage2_summary((SxStudent) SecurityUtils.getSubject().getPrincipal(), stage2_summary));
        }
    }
}
