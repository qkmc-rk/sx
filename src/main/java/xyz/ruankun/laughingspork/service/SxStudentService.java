package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;


import java.util.List;

public interface SxStudentService {

/**
 * 学生服务类接口
 *
 *
 */


    /**
     * 用学号查找学生信息
     * @param StuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxStudent
     */
    SxStudent getByStuNo(String StuNo);


    /** 
     * 教师通过教师号查找管理学生
     * @param teacherNo :
     * @return: java.util.List<xyz.ruankun.laughingspork.entity.SxStudent>
     */
    List<SxStudent> getByTeacherNo(String teacherNo);

    /**
     * 查找小组成员列表
     * @param groupCode :
     * @return: java.util.List<xyz.ruankun.laughingspork.entity.SxStudent>
     */
    List<SxStudent> getGroupList(String groupCode);

    /**
     * 学生保存鉴定表内容
     * @param practiceContent :
     * @param selfSummary :
     * @return: xyz.ruankun.laughingspork.entity.SxStudent
     */
    SxIdentifyForm saveIndentifyForm(SxStudent sxStudent, String practiceContent, String selfSummary);

    /**
     * 保存实习阶段的实习总结
     * @param sxStudent :
     * @param stage1_summary :
     * @return: xyz.ruankun.laughingspork.entity.SxReport
     */
    SxReport stage1_summary(SxStudent sxStudent, String stage1_summary);

    SxReport stage2_summary(SxStudent sxStudent,String stage2_summary);

    SxReport stage3_summary(SxStudent sxStudent,String stage3_summary);

}
