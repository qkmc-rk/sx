package xyz.ruankun.laughingspork.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import xyz.ruankun.laughingspork.shiro.CustomCredentialsMatcher;
import xyz.ruankun.laughingspork.shiro.UserModularRealmAuthenticator;
import xyz.ruankun.laughingspork.shiro.realm.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //  shiro拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //  过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->

        // 配置不被拦截的资源及链接
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/swagger-ui.html", "anon");

        //  配置需要认证权限的 未生效 原因未知
//        filterChainDefinitionMap.put("/student/**", "roles[student]");

        filterChainDefinitionMap.put("/**", "anon");
        //  退出拦截器
//        filterChainDefinitionMap.put("/logout", "logout");
        //  未登录的跳转链接
        shiroFilterFactoryBean.setLoginUrl("/login");
        //  登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //  未授权的跳转链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     *
     * @return: org.apache.shiro.authc.credential.HashedCredentialsMatcher
     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        //散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        //散列的次数，比如散列两次，相当于 md5(md5(""));
//        hashedCredentialsMatcher.setHashIterations(2);
//        return hashedCredentialsMatcher;
//    }

    //自定义身份认证Realm（包含用户名密码校验，权限校验等）
    @Bean
    public StudentRealm studentRealm() {
        StudentRealm studentRealm = new StudentRealm();
        studentRealm.setCredentialsMatcher(new CustomCredentialsMatcher());
        return studentRealm;
    }

    @Bean
    public TeacherRealm teacherRealm() {
        TeacherRealm teacherRealm = new TeacherRealm();
        teacherRealm.setCredentialsMatcher(new CustomCredentialsMatcher());
        return teacherRealm;
    }


    @Bean
    public CollegePrincipalRealm collegePrincipalRealm() {
        CollegePrincipalRealm CollegePrincipalRealm = new CollegePrincipalRealm();
        CollegePrincipalRealm.setCredentialsMatcher(new CustomCredentialsMatcher());
        return CollegePrincipalRealm;
    }


    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setAuthenticator(modularRealmAuthenticator());
        List<Realm> realmList = new ArrayList<>();
        realmList.add(studentRealm());
        realmList.add(teacherRealm());
        realmList.add(collegePrincipalRealm());
        securityManager.setRealms(realmList);
        return securityManager;
    }

    //开启shiro aop注解支持，不开启的话权限验证就会失效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //处理异常，当用户没有权限时设置跳转到401页面
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        //数据库异常处理
        mappings.setProperty("DatabaseException", "databaseError");
        //未经过认证
        mappings.setProperty("UnauthorizedException", "401");
        // None by default
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        // No default
        simpleMappingExceptionResolver.setDefaultErrorView("error");
        // Default is "exception"
        simpleMappingExceptionResolver.setExceptionAttribute("ex");
        return simpleMappingExceptionResolver;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator() {
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }
}
