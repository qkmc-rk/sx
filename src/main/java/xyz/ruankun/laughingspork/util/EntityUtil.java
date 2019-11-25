package xyz.ruankun.laughingspork.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 数据库数据entity更新工具类
 */
public class EntityUtil {

    public static final Logger logger = LoggerFactory.getLogger(EntityUtil.class);


    /**
     * @param young 前台所传数据
     * @param old   数据原有数据
     * @param <T>
     */
    public static <T extends Object> void update(T young, T old) {
        Class clazz = young.getClass();

        Field[] fields = clazz.getDeclaredFields();
        //获取该类所有属性集
        for (Field field : fields) {
            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String methodGet = "get" + firstLetter + fieldName.substring(1);    //构造get方法
            String methodSet = "set" + firstLetter + fieldName.substring(1);    //构造set方法
            try {
                Method getMethod = clazz.getDeclaredMethod(methodGet, new Class[]{});
                Object object = getMethod.invoke(young, new Object[]{});
                //若young中某个字段值为null，则与old数据进行对比
                if (object == null) {
                    //若old数据中该字段也为null，则继续下次循环
                    if (getMethod.invoke(old, new Object[]{}) == null) {
                        continue;
                    } else {
                        //获取set方法， 通过field获取该方法所需参数类型
                        Method setMethod = clazz.getDeclaredMethod(methodSet, new Class[]{field.getType()});
                        Object[] objects = {getMethod.invoke(old, new Object[]{})};
                        setMethod.invoke(young, objects);   //开始更新
                    }
                }
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }
    }

    public static <T extends Object> void setNullFiledToString(T t) {
        Class clazz = t.getClass();

        Field[] fields = clazz.getDeclaredFields();
        //获取该类所有属性集
        for (Field field : fields) {
            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String methodGet = "get" + firstLetter + fieldName.substring(1);    //构造get方法
            String methodSet = "set" + firstLetter + fieldName.substring(1);    //构造set方法
            try {
                Method getMethod = clazz.getDeclaredMethod(methodGet, new Class[]{});
                Method setMethod = clazz.getDeclaredMethod(methodSet, new Class[]{field.getType()});

                Object object = getMethod.invoke(t, new Object[]{});
                //若young中某个字段值为null，则与修改其为空字符串
                if (object == null && field.getType().toString().contains("String")) {
                    setMethod.invoke(t, "");
                }
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }

    }

}
