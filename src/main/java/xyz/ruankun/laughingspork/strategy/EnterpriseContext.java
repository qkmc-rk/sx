package xyz.ruankun.laughingspork.strategy;

import java.util.List;

public class EnterpriseContext {

    private EnterpriseStrategy strategy;

    public EnterpriseContext(EnterpriseStrategy strategy) {
        this.strategy = strategy;
    }

    /** 
     * 访问接口验证企业三要素
     * @param enterprise :
     * @return: java.lang.String
     */
    public String authEnterprise(Enterprise enterprise) {
        return strategy.authEnterprise(enterprise);
    }

}
