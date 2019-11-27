package xyz.ruankun.laughingspork.strategy;

// 存放企业三要素
public class Enterprise {
    // 企业名称
    private String name;

    // 统一社会信用代码
    private String creditCode;

    // 企业法人
    private String legalPersion;

    public Enterprise(String name, String creditCode, String legalPersion) {
        this.name = name;
        this.creditCode = creditCode;
        this.legalPersion = legalPersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getLegalPersion() {
        return legalPersion;
    }

    public void setLegalPersion(String legalPersion) {
        this.legalPersion = legalPersion;
    }

    @Override
    public String toString() {
        return "EnterpriseInfo{" +
                "name='" + name + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", legalPersion='" + legalPersion + '\'' +
                '}';
    }
}
