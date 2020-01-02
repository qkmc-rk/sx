package xyz.ruankun.laughingspork;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import org.junit.Test;
import xyz.ruankun.laughingspork.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JUnitTest1 {

    @Test
    public void test1(){
        String date = "2019-12-11";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(new java.sql.Date(simpleDateFormat.parse(date).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[] code =  VerifyCodeUtil.createImage();
        System.out.println(code[0].toString());
    }
    @Test
    public void m2(){
        String pwd1 = "ruankun521";
        String pwd2 = "@Sicau.edu.cn1";
        String pwd3 = "ruanqiongQdd122~";
        String pwd4 = "Rqx3-1=2df23";
        System.out.println(StrongPwdValidator.validate(pwd1));
        System.out.println(StrongPwdValidator.validate(pwd2));
        System.out.println(StrongPwdValidator.validate(pwd3));
        System.out.println(StrongPwdValidator.validate(pwd4));
    }

    @Test
    public void testSystemType(){
        System.out.println(SystemUtil.isWindows());
        System.out.println(SystemUtil.isLinux());
        System.out.println(SystemUtil.isMac());
    }
    @Test
    public void testEncoding(){
        System.out.println(DateUtil.upper);
        for (int i=0; i<DateUtil.upper.length; i++){
            System.out.println(DateUtil.upper[i]);
        }
    }

}
