package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.*;
import xyz.ruankun.laughingspork.service.*;
import xyz.ruankun.laughingspork.shiro.UserToken;


@RestController
@RequestMapping("/user")
@Api(value = "用户类", description = "处理用户登录、注册、注销请求")
public class UserController {

    @Autowired
    SxStudentService sxStudentService;

    @Autowired
    SxTeacherService sxTeacherService;

    @Autowired
    SxCorpService sxCorpService;

    @Autowired
    SxCorpTeacherService sxCorpTeacherService;

    @Autowired
    SxCollegePrincipalService sxCollegePrincipalService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "用户登录接口", notes = "account类型与loginType一一对应,严格区分大小写.\n" +
            "account(loginType):    " +
            "学生学号(Student)、校内导师编号(Teacher)、" +
            "校外导师账号(CorpTeacher)、实习公司负责人账号(Corp)、" +
            "学院负责人账号(CollegePricipal)", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "2019209007", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "21232F297A57A5A743894A0E4A801FC3", required = true, paramType = "query"),
            @ApiImplicitParam(name = "loginType", value = "Student", required = true, paramType = "query")
    })
    @PostMapping("/login")
    public String login(String account, String password, String loginType) {
        Subject subject = SecurityUtils.getSubject();
        //  设置Session永不过期
        subject.getSession().setTimeout(-1000L);
        try {
            subject.login(new UserToken(account, password, loginType));
            return "登陆成功";
        } catch (AuthenticationException e) {
            logger.error(e.toString());
            return "登录失败";
        }
    }

    @ApiOperation(value = "学生用户注册")
    @PostMapping("/studentRegister")
    public String register(SxStudent sxStudent) {
        logger.info(sxStudent.toString());
        try {
            SxStudent querySxStudent = sxStudentService.findByStuNo(sxStudent.getStuNo());
            if (querySxStudent == null) {
                sxStudentService.save(sxStudent);
                return "注册成功";
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "注册失败";
    }

    @ApiOperation(value = "教师用户注册")
    @PostMapping("/teacherRegister")
    public String teacherRegister(SxTeacher sxTeacher) {
        logger.info(sxTeacher.toString());
        try {
            SxTeacher querySxTeacher = sxTeacherService.findByTeacherNo(sxTeacher.getTeacherNo());
            if (querySxTeacher == null) {
                sxTeacherService.save(sxTeacher);
                return "注册成功";
            } else {
                return "用户名已占用";
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "注册失败";
    }

    @ApiOperation(value = "实习公司负责人注册")
    @PostMapping("/corpRegister")
    public String corpRegister(SxCorp sxCorp) {
        logger.info(sxCorp.toString());
        try {
            SxCorp querySxCorp = sxCorpService.findByAccount(sxCorp.getAccount());
            if (querySxCorp == null) {
                sxCorpService.save(sxCorp);
                return "注册成功";
            } else {
                return "用户名已占用";
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "注册失败";
    }

    @ApiOperation(value = "实习公司导师注册")
    @PostMapping("/corpTeacherRegister")
    public String corpTeacherregister(SxCorpTeacher sxCorpTeacher) {
        logger.info(sxCorpTeacher.toString());
        try {
            SxCorpTeacher querySxCorpTeacher = sxCorpTeacherService.findByAccount(sxCorpTeacher.getAccount());
            if (querySxCorpTeacher == null) {
                sxCorpTeacherService.save(sxCorpTeacher);
                return "注册成功";
            } else {
                return "用户名已占用";
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "注册失败";
    }


    @ApiOperation(value = "学院领导小组注册")

    @PostMapping("/collegePrincipalRegister")
    public String collegePrincipalRegister(SxCollegePrincipal sxCollegePrincipal) {
        logger.info(sxCollegePrincipal.toString());
        try {
            SxCollegePrincipal querySxCollegePrincipal = sxCollegePrincipalService.findByAccount(sxCollegePrincipal.getAccount());
            if (querySxCollegePrincipal == null) {
                sxCollegePrincipalService.save(sxCollegePrincipal);
                return "注册成功";
            } else {
                return "用户名已占用";
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "注册失败";
    }

    @ApiOperation(value = "用户注销接口")
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "/login";
    }
}
