package xyz.ruankun.laughingspork.strategy.impl;


import org.apache.http.client.methods.HttpHead;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import xyz.ruankun.laughingspork.config.YamlConfig;
import xyz.ruankun.laughingspork.strategy.Enterprise;
import xyz.ruankun.laughingspork.strategy.EnterpriseStrategy;
import xyz.ruankun.laughingspork.util.HttpUtil;
import xyz.ruankun.laughingspork.util.QiChaChaUtil;
import xyz.ruankun.laughingspork.util.YamlConfigurerUtil;


import java.util.List;

@Component
public class Qichacha implements EnterpriseStrategy {
    public static final Logger logger = LoggerFactory.getLogger(Qichacha.class);

    private String appKey = YamlConfigurerUtil.getStrYmlVal("qichacha.appkey");

    private String secKey = YamlConfigurerUtil.getStrYmlVal("qichacha.seckey");

    private String apiUrl = YamlConfigurerUtil.getStrYmlVal("qichacha.apiurl");


    @Override
    public String authEnterprise(Enterprise enterprise) {
        String result = "";

        try {
            // auth header setting
            HttpHead reqHeader = new HttpHead();
            String[] autherHeader = QiChaChaUtil.RandomAuthentHeader(appKey, secKey);
            reqHeader.setHeader("Token", autherHeader[0]);
            reqHeader.setHeader("Timespan", autherHeader[1]);
            final String reqUri = apiUrl.concat("?key=").concat(appKey)
                    .concat("&regNo=").concat(enterprise.getCreditCode())
                    .concat("&companyName=").concat(enterprise.getName())
                    .concat("&frName=").concat(enterprise.getLegalPersion());
            String tokenJson = HttpUtil.httpGet(reqUri, reqHeader.getAllHeaders());

            // parse status from json
            JSONObject jsonObject = QiChaChaUtil.FormartJson(tokenJson);

            result = jsonObject.getString("Result");
            if (result.isEmpty()) {
                return null;
            } else {
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
