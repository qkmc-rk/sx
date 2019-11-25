package xyz.ruankun.laughingspork.config;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import xyz.ruankun.laughingspork.shiro.*;
import xyz.ruankun.laughingspork.shiro.realm.*;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //  自定义跨域拦截器
        Map<String, Filter> filter = new HashMap<>();
        filter.put("corsFilter", new CustomHttpAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filter);
        //  过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 处理跨域请求
        filterChainDefinitionMap.put("/**", "corsFilter");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

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


    // 注入自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        customSessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return customSessionManager;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setAuthenticator(modularRealmAuthenticator());
        List<Realm> realmList = new ArrayList<>();
        realmList.add(studentRealm());
        realmList.add(teacherRealm());
        securityManager.setRealms(realmList);
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * Shiro生命周期处理器
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
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
    public CustomSimpleMappingExceptionResolver createCustomSimpleMappingExceptionResolver() {
        CustomSimpleMappingExceptionResolver CustomSimpleMappingExceptionResolver = new CustomSimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        //数据库异常处理
        mappings.setProperty("DatabaseException", "databaseError");
        //未经过认证
        mappings.setProperty("UnauthorizedException", "401");
        // None by default
        CustomSimpleMappingExceptionResolver.setExceptionMappings(mappings);
        // No default
        CustomSimpleMappingExceptionResolver.setDefaultErrorView("error");
        // Default is "exception"
        CustomSimpleMappingExceptionResolver.setExceptionAttribute("ex");
        return CustomSimpleMappingExceptionResolver;
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
