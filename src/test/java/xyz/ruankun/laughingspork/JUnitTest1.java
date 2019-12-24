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
import xyz.ruankun.laughingspork.util.VerifyCodePool;
import xyz.ruankun.laughingspork.util.VerifyCodeUtil;

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
}
