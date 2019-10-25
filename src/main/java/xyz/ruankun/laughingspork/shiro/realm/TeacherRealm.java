package xyz.ruankun.laughingspork.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.ruankun.laughingspork.entity.SxTeacher;
import xyz.ruankun.laughingspork.service.SxTeacherService;

import java.util.HashSet;
import java.util.Set;

public class TeacherRealm extends AuthorizingRealm {
    @Autowired
    private SxTeacherService sxTeacherService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("teacher");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String teacherNo = (String) token.getPrincipal();
        SxTeacher sxTeacher = sxTeacherService.findByTeacherNo(teacherNo);
        if (sxTeacher == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sxTeacher,
                sxTeacher.getPassword(),
                getName());
        return simpleAuthenticationInfo;
    }

    @Override
    public String getName() {
        return "Teacher";
    }
}
