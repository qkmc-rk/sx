package xyz.ruankun.laughingspork.util.constant;


public class RespCode {

    public static final Integer SUCCESS_CODE = 1;

    public static final Integer FAILURE_CODE = -1;

    public static final String MSG_CLIENT_DATA_ERROR = "客户端数据错误";

    public static final String MSG_SUCCESS = "响应成功";

    public static final String MSG_SERVER_ERROR = "服务器故障";

    public static final String MSG_INVALID_OPERATION = "非法操作";


    //成功登录
    public static final Integer LOGIN_SUCCESS = 1;

    //未注册
    public static final Integer LOGIN_NO_USER = 0;

    //传入code 有误登录失败
    public static final Integer LOGIN_CODE_ERROR = -1;

    //传入的code已经被使用了
    public static final Integer LOGIN_CODE_USED = -2;

    //服务器在处理一些操作的时候发生了异常
    public static final Integer LOGIN_SERVER_ERROR = -3;

    public static final Integer LOGIN_BLACK_USER = -4;

    public static final Integer FLUSH_TOKEN_ERROR = -5;

    //注册时要用的CODE

    //成功注册
    public static final Integer REGISTER_SUCCESS = 1;

    //已经注册过了
    public static final Integer REGISTER_ALREADY_DOWN = 0;

    //传入code 有误注册失败
    public static final Integer REGISTER_CODE_ERROR = -1;

    //传入的code已经被使用了
    public static final Integer REGISTER_CODE_USED = -2;

    //服务器在处理一些操作的时候发生了异常
    public static final Integer REGISTER_SERVER_ERROR = -3;


    //登录时微信返回的code
    //已经被使用的code
    public static final Integer WX_USED_CODE = 40163;
    public static final Integer WX_ERROR_CODE = 40029;

    //使用aop处理时抛出了异常
    public static final Integer AOP_SERVER_ERROR = -4;

    public static final Integer AUTH_ERROR = 403;

    public static final Integer TEACHER = 1;
    public static final Integer STUDENT = 0;

}
