package xyz.ruankun.laughingspork.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 综合成绩生成类
 */
public class GradeCalcUtil {

    /**
     * 匿名内部类，方便计算
     */
    private static final Map<String,Integer> GRADABLE =new HashMap(){
        {
            put("优秀",5);
            put("良好",4);
            put("中等",3);
            put("及格",2);
            put("不及格",1);
        }
    };

    public static String calcComprehsvGrade(String corpTeacherGrade,String teacherGrade){
        if(corpTeacherGrade.equals(null) || teacherGrade.equals(null)){
            return null;
        }
        Integer ct= GRADABLE.get(corpTeacherGrade);
        Integer t= GRADABLE.get(teacherGrade);
        Integer min=Math.min(ct,t);
        String comprehsvGrade = null;
        for (Map.Entry<String,Integer> entry: GRADABLE.entrySet()) {
            if(entry.getValue()==min){
                comprehsvGrade=entry.getKey();
            }
        }

        return comprehsvGrade;
    }
}
