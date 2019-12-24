package xyz.ruankun.laughingspork.util;

public class SystemUtil {

    /**
     * 判断当前平台是否是windows
     * @return windows true | else false
     */
    public static boolean isWindows(){
        String platform = System.getProperty("os.name");
        boolean isUnixBased = platform.toLowerCase().indexOf("linux") > -1 || platform.toLowerCase().indexOf("mac") > -1;
        if (isUnixBased){
            return false;   // 不是windows
        }else {
            return true;    // 不是windows
        }
    }

    /**
     * 判断当前平台是否是linux
     * @return linux true | else false
     */
    public static boolean isLinux(){
        if (!isWindows()){
            String platform = System.getProperty("os.name");
            if (platform.toLowerCase().indexOf("linux") > -1){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前平台是否是mac
     * @return mac true | else false
     */
    public static boolean isMac(){
        if (!isWindows() && !isLinux()){
            return true;
        }
        return false;
    }
}
