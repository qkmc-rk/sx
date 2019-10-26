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
import xyz.ruankun.laughingspork.entity.SxCorp;
import xyz.ruankun.laughingspork.service.SxCorpService;

public class CorpRealm extends AuthorizingRealm {
    @Autowired
    private SxCorpService sxCorpService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("corp");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        SxCorp sxCorp = sxCorpService.findByAccount(account);
        if (sxCorp == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sxCorp,
                sxCorp.getPassword(),
                getName());
        return simpleAuthenticationInfo;
    }

    @Override
    public String getName() {
        return "Corp";
    }
}
