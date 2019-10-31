package xyz.ruankun.laughingspork.util;

import java.sql.Date;

public class DateUtil {

    /**
     * 返回当前日期
     *
     * @return: java.sql.Date
     */
    public static Date today() {
        return new Date(System.currentTimeMillis());
    }
}
