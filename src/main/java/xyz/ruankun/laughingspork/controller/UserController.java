package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.*;
import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStagemanage;
import xyz.ruankun.laughingspork.service.SxIdentifyFormService;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.service.SxStudentService;
import xyz.ruankun.laughingspork.shiro.UserToken;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.VerifyCodePool;
import xyz.ruankun.laughingspork.util.VerifyCodeUtil;
import xyz.ruankun.laughingspork.util.constant.RespCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Api(tags = {"用户公用接口"})
@CrossOrigin
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    SxStudentService sxStudentService;

    @Autowired
    SxReportService sxReportService;

    @Autowired
    SxIdentifyFormService sxIdentifyFormService;

    @ApiOperation(value = "用户登录接口", notes = "account类型与loginType一一对应,严格区分大小写.\n" +
            "account(loginType):    " +
            "学生学号(Student)、校内导师编号(Teacher)、",
            httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "123456", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "123", required = true, paramType = "query"),
            @ApiImplicitParam(name = "loginType", value = "Teacher", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "query")
    })
    @PostMapping("/login")
    public ResponseVO login(String account, String password, String loginType, String code) {
        if(null == code){
            return ControllerUtil.getFalseResultMsgBySelf("verify code cannot be null");
        }
        if(!VerifyCodeUtil.verify(code.toLowerCase())){
            return ControllerUtil.getFalseResultMsgBySelf("verify code is wrong,please retry after refresh page");
        }else {
            Subject subject = SecurityUtils.getSubject();
            //  设置Session30分钟过期 30分钟没有交互 Seeion将被删除
            subject.getSession().setTimeout(1800000);
            try {
                subject.login(new UserToken(account, password, loginType));
                HashMap<String, Object> data = new HashMap<>();
                //登录成功返回SessionId
                data.put("Authorization", subject.getSession().getId());

                //判断是否有鉴定表和报告册记录 否则创建
                if (sxReportService.getReportInfo(account) == null) {
                    SxReport sxReport = new SxReport();
                    sxReport.setStuNo(account);
                    sxReportService.saveReport(sxReport);
                }
                if (sxIdentifyFormService.getIdentifyInfo(account) == null) {
                    SxIdentifyForm sxIdentifyForm = new SxIdentifyForm();
                    sxIdentifyForm.setStuNo(account);
                    sxIdentifyFormService.saveIdentifyForm(sxIdentifyForm);
                }


                return ControllerUtil.getSuccessResultBySelf(data);
            } catch (IncorrectCredentialsException e) {
                return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_VALIDATION_ERROR);
            } catch (UnknownAccountException e) {
                return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_VALIDATION_ERROR);
            } catch (Exception e) {
                logger.error(e.toString());
                return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_UNKNOWN_ERROR);
            }
            //fi
        }
    }


    @ApiOperation(value = "用户注销接口")
    @GetMapping("/logout")
    @RequiresAuthentication
    public ResponseVO logout() {
        SecurityUtils.getSubject().logout();
        return ControllerUtil.getSuccessResultBySelf("注销成功");
    }

    @ApiOperation(value = "返回当前填写阶段信息", httpMethod = "GET")
    @GetMapping("/reportStage")
    @RequiresAuthentication
    public ResponseVO nowReportStage() {
        SxStagemanage sxStagemanage = sxStudentService.getNowReportStage();
        return ControllerUtil.getSuccessResultBySelf(sxStagemanage);
    }

    @ApiOperation("生成验证码")
    @GetMapping("/verifycode")
    public void getCode(HttpServletResponse response) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyCodeUtil.createImage();
        //将验证码存入验证码池
        VerifyCodeUtil.setVerifyCode(objs[0].toString().toLowerCase());
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

}
