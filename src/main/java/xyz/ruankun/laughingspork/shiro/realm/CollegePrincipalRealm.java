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
import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.service.SxCollegePrincipalService;

public class CollegePrincipalRealm extends AuthorizingRealm {
    @Autowired
    private SxCollegePrincipalService sxCollegePrincipalService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("collegePrincipal");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        SxCollegePrincipal sxCollegePrincipal = sxCollegePrincipalService.findByAccount(account);
        if (sxCollegePrincipal == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sxCollegePrincipal,
                sxCollegePrincipal.getPassword(),
                getName());
        return simpleAuthenticationInfo;
    }

    @Override
    public String getName() {
        return "CollegePrincipal";
    }
}
