package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.shiro.UserToken;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;


@RestController
@RequestMapping("/user")
@Api(value = "用户类", description = "处理用户登录、注册、注销请求")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "用户登录接口", notes = "account类型与loginType一一对应,严格区分大小写.\n" +
            "account(loginType):    " +
            "学生学号(Student)、校内导师编号(Teacher)、" +
            "学院负责人账号(CollegePricipal)", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "2019209007", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "admin", required = true, paramType = "query"),
            @ApiImplicitParam(name = "loginType", value = "Student", required = true, paramType = "query")
    })
    @PostMapping("/login")
    public ResponseVO login(String account, String password, String loginType) {
        Subject subject = SecurityUtils.getSubject();
        //  设置Session永不过期
        subject.getSession().setTimeout(-1000L);
        try {
            subject.login(new UserToken(account, password, loginType));
            return ControllerUtil.getSuccessResultBySelf("登录成功");
        } catch (IncorrectCredentialsException e) {
            return ControllerUtil.getFalseResultMsgBySelf("密码错误");
        } catch (UnknownAccountException e) {
            return ControllerUtil.getFalseResultMsgBySelf("用户名错误");
        } catch (Exception e) {
            return ControllerUtil.getFalseResultMsgBySelf("未知错误");
        }
    }
}
