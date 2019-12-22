package xyz.ruankun.laughingspork.util;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 存放验证码的池子
 * 全局只有一个 所有验证码存到这里
 *
 */
public abstract class VerifyCodePool {

    private static final Logger logger = LoggerFactory.getLogger(VerifyCodePool.class);

    private VerifyCodePool(){}

    //验证码池
    //怎么存？ <验证码,过期时间>
    private static Map<String,Date> verifycodes = new ConcurrentHashMap<>(); //饿汉

    //验证么最大有效时间  30 分钟
    private final static long MAX_VALID_TIME = 1800l * 1000;

    //计数器最大值,达到这个值就清理一次map中的值。
    private static final long MAX_COUNT = 10000l;

    //计数器 每隔
    private static Integer count = 0;

    /**
     * 放入一个验证码
     * @param code
     */
    public static void setVerifyCode(String code){
        count++;
        logger.info("set verifycode to pool:" + code);
        verifycodes.put(code, new Date());
        logger.info("获取到的验证码： get verifycode: " + verifycodes.get(code));
    }

    /**
     * 验证并删除一个验证码
     * @param code
     * @return
     */
    public static boolean verify(String code){
        if(code == null) {
            return false;
        }
        code = code.toLowerCase();
        cleanPool();
        Date date = verifycodes.get(code);
        if(null == date){
            //验证码不存在
            logger.info("verify code is not here");
            return false;
        }else {
            logger.info("验证码验证:" + date.toString() + "传入的code:" + code);
            //验证码是存在的
            //验证码是否过期
            boolean outOfDate = new Date().getTime() > date.getTime() + MAX_VALID_TIME;
            //已经验证过了就要把验证码删除掉
            verifycodes.remove(code);
            if (outOfDate){
                return false;
            }else {
                return true;
            }
        }
    }


    /**
     * 一万次清理一次池子
     */
    private static void cleanPool(){
        if (count >= MAX_COUNT){
            count = 0;
            // 清理验证码时需要锁定池子，不能使用的时候清理
            synchronized (VerifyCodePool.class){
                Map newMap = new ConcurrentHashMap<>();
                Set<String> set = verifycodes.keySet();
                for (String key :
                        set) {
                    Date date = verifycodes.get(key);
                    if (date.getTime() + MAX_VALID_TIME > new Date().getTime()){
                        // 只保留有效的
                        newMap.put(key, date);
                    }
                }
                //老的池子消灭了?
                //新的池子
                verifycodes = newMap;
            }
        }

    }
}
