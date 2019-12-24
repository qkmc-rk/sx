package xyz.ruankun.laughingspork.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 强密码校验器
 *
 */
public class StrongPwdValidator {

    private final static Integer MIN_LENGTH = 12;

    // 字母表
    private final static String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private final static String BIG_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // 特殊字符
    private final static String SPECIAL_CHARS = "~!@#$%^&*()_+-={}[],./<>?:|";

    private final static String NUMBERS = "1234567890";

    /**
     *  先判断传入密码的长度是否够12位，其次判断是否包含各个类型的符号.
     *  密码要求: 大小写字母特殊字符以及数字, 且长度大于12位.
     *  @param pwd
     *  @return
     */
    public static Map<Boolean,String> validate(String pwd){

        Map<Boolean, String> map = new HashMap<>(1);
        if (null == pwd){
            map.put(false, "pwd is null.");
        }
        boolean isLongEnough = (pwd.length() >= MIN_LENGTH)?true:false;
        if (!isLongEnough){
            //长度不够
            map.put(false,"the password length is lower than 12.");
            return map;
        }else {
            //长度够了
            boolean hasBigLetters = false;
            boolean hasSmallLetters = false;
            boolean hasNumbers = false;
            boolean hasSpecialChars = false;
            int len = pwd.length();

            for (int i = 0; i < len; i++){
                if(!hasSmallLetters && SMALL_LETTERS.indexOf(pwd.charAt(i)) > -1){
                    hasSmallLetters = true;
                }
                if(!hasBigLetters && BIG_LETTERS.indexOf(pwd.charAt(i)) > -1){
                    hasBigLetters = true;
                }
                if(!hasNumbers && NUMBERS.indexOf(pwd.charAt(i)) > -1){
                    hasNumbers = true;
                }
                if(!hasSpecialChars && SPECIAL_CHARS.indexOf(pwd.charAt(i)) > -1){
                    hasSpecialChars = true;
                }
            }

            if (!hasBigLetters){
                map.put(false,"no big letters in your password");
                return map;
            }else if(!hasSmallLetters){
                map.put(false,"no small letters in your password");
                return map;
            }else if(!hasNumbers){
                map.put(false,"no numbers in your password");
                return map;
            }else if(!hasSpecialChars){
                map.put(false,"no special characters in your password: ~!@#$%^&*()_+-={}[],./<>?:|");
                return map;
            }
            map.put(true,"password is validated");
            return map;
        }

    }
}
