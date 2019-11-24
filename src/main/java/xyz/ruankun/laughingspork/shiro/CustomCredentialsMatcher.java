package xyz.ruankun.laughingspork.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    Logger logger = LoggerFactory.getLogger(CustomCredentialsMatcher.class);

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        // 拿到密码后加密
        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
        //  明文密码 测试使用
//        Object tokenCredentials = String.valueOf(token.getPassword());
        Object accountCredentials = getCredentials(info);
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
        return equals(tokenCredentials, accountCredentials);
    }

    /**
     * 密码加密
     *
            * @param data : 传进来的明文密码
     * @return: java.lang.String
     */
    private String encrypt(String data) {
        //密码验证方式 比如 md5或者sha256等
        String md5Hash = new Md5Hash(data).toString().toUpperCase();
        return md5Hash;
    }
}