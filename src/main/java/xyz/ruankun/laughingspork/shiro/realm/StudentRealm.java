package xyz.ruankun.laughingspork.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxStudentService;

public class StudentRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(StudentRealm.class);

    @Autowired
    private SxStudentService sxStudentService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (principals.getRealmNames().toString().contains("Student")) {
            simpleAuthorizationInfo.addRole("Student");
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //  获得当前用户的用户名
        String stuNo = (String) token.getPrincipal();
        //  根据用户名查询用户
        SxStudent sxStudent = sxStudentService.findByStuNo(stuNo);
        if (sxStudent == null) {
            return null;
        }
        //校验用户名密码是否正确
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sxStudent,
                sxStudent.getPassword(),
                getName()
        );
        return simpleAuthenticationInfo;
    }

    @Override
    public String getName() {
        return "Student";
    }
}
