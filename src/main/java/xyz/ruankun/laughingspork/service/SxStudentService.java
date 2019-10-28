package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;


import java.util.List;

public interface SxStudentService {

/**
 * 学生服务类接口
 *
 *
 */

    /**
     * 学生查看自己信息(SxStudent)
     * @param StuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxStudent
     */
    SxStudent findSelfInfoByStuNo(String StuNo);

    /**
     * 返回这个学生相应的校内导师信息
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxTeacher
     */

    SxTeacher getTeacherInfo(SxStudent sxStudent);

    /**
     * 返回这个学生的鉴定表信息
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxIdentifyForm
     */

    SxIdentifyForm getSelfIndentifyInfo(SxStudent sxStudent);

    /**
     * 返回这个学生的报告册信息
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxReport
     */

    SxReport getSelfReportInfo(SxStudent sxStudent);



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

    void save(SxStudent sxStudent);

    SxStudent findByStuNo(String StuNo);
}

