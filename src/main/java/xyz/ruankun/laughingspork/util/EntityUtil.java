package xyz.ruankun.laughingspork.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 数据库数据entity更新工具类
 */
public class EntityUtil {

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
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
