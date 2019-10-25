package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.repository.SxStudentRepository;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private SxStudentRepository sxStudentRepository;

    @Autowired
    SxStudentService sxStudentService;


    @ApiOperation(value = "学生查看自己信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuNo",value = "学生学号\n eg:2019209007", required = true, paramType = "query"),
    })
    @GetMapping("/getOne")
    public ResponseVO getOneStudent(String stuNo) {
        SxStudent sxStudent = sxStudentService.getByStuNo(stuNo);
        if (sxStudent == null){
            return ControllerUtil.getFalseResultMsgBySelf("没有找到该同学的数据");
        }
        return ControllerUtil.getDataResult(sxStudent);
    }

    @ApiOperation(value = "学生填写鉴定表信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "practiceContent",value = "实习内容", required = true, paramType = "query"),
            @ApiImplicitParam(name = "selfSummary",value = "自我总结", required = true, paramType = "query"),

    })
    @GetMapping("/fillIdentifyForm")
    public ResponseVO fillIndentifyForm(SxStudent student,@RequestParam String practiceContent,@RequestParam String selfSummary){
        if (practiceContent == null || selfSummary == null){
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        }
        else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.saveIndentifyForm(new SxStudent(),practiceContent,selfSummary));
        }
    }

    @ApiOperation(value = "学生填写报告阶段信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage1_summary",value = "阶段一", required = true, paramType = "query"),
    })
    @GetMapping("/stage1_summary")
    public ResponseVO stage1_summary(@RequestParam String stage1_summary){
        if (stage1_summary == null){
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        }
        else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage1_summary(new SxStudent(),stage1_summary));
        }
}

    @ApiOperation(value = "学生填写报告阶段信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stage2_summary",value = "阶段二", required = true, paramType = "query"),
    })
    @GetMapping("/stage2_summary")
    public ResponseVO stage2_summary(@RequestParam String stage2_summary){
        if (stage2_summary == null){
            return ControllerUtil.getFalseResultMsgBySelf("请填写完成所有内容");
        }
        else {
            //保存鉴定表内容到数据库
            return ControllerUtil.getDataResult(sxStudentService.stage1_summary(new SxStudent(),stage2_summary));
        }
    }



    @ApiOperation(value = "学生组长查看组成员",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupCode",value = "组编号", required = true, paramType = "query"),
    })
    @GetMapping("/groupManage")
    public ResponseVO gruopStudentsList(String groupCode){
        List<SxStudent> sxStudentList = sxStudentService.getGroupList(groupCode);
        if (sxStudentList == null){
            return ControllerUtil.getFalseResultMsgBySelf( "您没有找到相关组员数据");
        }
        return ControllerUtil.getSuccessResultBySelf(sxStudentList);
    }
}
