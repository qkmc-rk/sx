package xyz.ruankun.laughingspork.util;

import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 描述：<br>
 *
 * @author zhangwh<br>
 * @version 1.0<br>
 * 日期：2019年3月18日 下午7:11:08
 */


public class QiChaChaUtil {



    // 获取Auth Code
    public static final String[] RandomAuthentHeader(String appkey, String seckey) {
        String timeSpan = String.valueOf(System.currentTimeMillis() / 1000);
        String[] authentHeaders = new String[]{DigestUtils.md5Hex(appkey.concat(timeSpan).concat(seckey)).toUpperCase(), timeSpan};
        return authentHeaders;
    }

    // 解析JSON
    public static JSONObject FormartJson(String jsonString) throws JSONException {
        return new JSONObject(jsonString);
    }


}
