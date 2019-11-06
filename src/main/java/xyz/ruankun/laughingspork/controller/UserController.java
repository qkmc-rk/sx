package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.shiro.UserToken;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.constant.RespCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;

import java.util.HashMap;


@RestController
@RequestMapping("/user")
@Api(tags = {"用户登录、注销"})
@CrossOrigin
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "用户登录接口", notes = "account类型与loginType一一对应,严格区分大小写.\n" +
            "account(loginType):    " +
            "学生学号(Student)、校内导师编号(Teacher)、",
            httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "123456", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "123", required = true, paramType = "query"),
            @ApiImplicitParam(name = "loginType", value = "Teacher", required = true, paramType = "query")
    })
    @RequestMapping("/login")
    public ResponseVO login(String account, String password, String loginType) {
        Subject subject = SecurityUtils.getSubject();
        //  设置Session不过期
        subject.getSession().setTimeout(-1000L);
        try {
            subject.login(new UserToken(account, password, loginType));
            HashMap<String, Object> data = new HashMap<>();
            //登录成功返回SessionId
            data.put("Authorization", subject.getSession().getId());
            return ControllerUtil.getSuccessResultBySelf(data);
        } catch (IncorrectCredentialsException e) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_VALIDATION_ERROR);
        } catch (UnknownAccountException e) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_VALIDATION_ERROR);
        } catch (Exception e) {
            return ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_UNKNOWN_ERROR);
        }
    }


    @ApiOperation(value = "用户注销接口")
    @GetMapping("/logout")
    public ResponseVO logout() {
        SecurityUtils.getSubject().logout();
        return ControllerUtil.getSuccessResultBySelf("注销成功");
    }
}