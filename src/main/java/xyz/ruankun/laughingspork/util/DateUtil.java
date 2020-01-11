package xyz.ruankun.laughingspork.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

    public static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    // 使用char 出现部分平台中文乱码问题
    public final static String[] upper = {"零","一","二","三","四","五","六","七","八","九"};//"〇一二三四五六七八九".toCharArray();

    /**
     * 返回当前日期
     *
     * @return: java.sql.Date
     */
    public static Date getSqlDate() {
        return new Date(System.currentTimeMillis());
    }


    public static String getNowUpperDate() {
        return getUpperDate(new java.util.Date());
    }

    /**
     * 返回中文日期
     *
     * @return yyyy年MM月dd日
     */
    public static String getUpperDate(java.util.Date javaDate) {
        if (javaDate == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(javaDate);
        //支持yyyy-MM-dd、yyyy/MM/dd、yyyyMMdd等格式
        if (date == null) return null;
        //非数字的都去掉
        date = date.replaceAll("\\D", "");
        if (date.length() != 8) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {//年
            sb.append(upper[Integer.parseInt(date.substring(i, i + 1))]);
        }
        sb.append("年");//拼接年
        int month = Integer.parseInt(date.substring(4, 6));
        if (month <= 10) {
            sb.append(upper[month]);
        } else {
            sb.append("十").append(upper[month % 10]);
        }
        sb.append("月");//拼接月

        int day = Integer.parseInt(date.substring(6));
        if (day < 10) {
            sb.append(upper[day]);
        } else if (day < 20) {
            sb.append("十").append(upper[day % 10]);
        } else {
            sb.append(upper[day / 10]).append("十");
            int tmp = day % 10;
            if (tmp != 0) sb.append(upper[tmp]);
        }
        sb.append("日");//拼接日
        return sb.toString();
    }

    /**
     * 字符串时间处理
     * @param date 格式如：yyyy-MM-dd
     * @return java.sql.date类
     */
    public static java.util.Date getDateByStr(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info("日期转换处理异常，日期无法转换：" + date);
            return null;
        }
    }

    /**
     * 字符串时间处理
     * @param date 格式如：yyyy-MM-dd
     * @return java.sql.date类
     */
    public static Date getSqlDateByStr(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new java.sql.Date(simpleDateFormat.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info("日期转换处理异常，日期无法转换：" + date);
            return null;
        }
    }

}
