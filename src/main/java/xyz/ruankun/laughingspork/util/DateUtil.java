package xyz.ruankun.laughingspork.util;

import java.sql.Date;

public class DateUtil {

    /**
     * 返回当前日期
     *
     * @return: java.sql.Date
     */
    public static final Date today() {
        java.util.Date datetime = new java.util.Date();
        return new Date(datetime.getYear(), datetime.getMonth(), datetime.getDate());
    }
}
