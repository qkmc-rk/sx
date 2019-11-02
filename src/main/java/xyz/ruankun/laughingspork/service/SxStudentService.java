package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;


public interface SxStudentService {


    /**
     * 学生查看自己信息(SxStudent)
     *
     * @param StuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxStudent
     */
    SxStudent findSelfInfoByStuNo(String StuNo);

    /**
     * 返回这个学生相应的校内导师信息
     *
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxTeacher
     */

    SxTeacher getTeacherInfo(SxStudent sxStudent);

    /**
     * 返回这个学生的鉴定表信息
     *
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxIdentifyForm
     */

    SxIdentifyForm getSelfIdentifyInfo(SxStudent sxStudent);

    /**
     * 返回这个学生的报告册信息
     *
     * @param sxStudent :
     * @return: xyz.ruankun.laughingspork.entity.SxReport
     */

    SxReport getSelfReportInfo(SxStudent sxStudent);


    /**
     * 学生保存鉴定表内容
     *
     * @param practiceContent :
     * @param selfSummary     :
     * @return: xyz.ruankun.laughingspork.entity.SxStudent
     */
    SxIdentifyForm saveIdentifyForm(SxStudent sxStudent, String practiceContent, String selfSummary);

    /**
     * 保存实习阶段的实习总结
     *
     * @param sxStudent      :
     * @param stage1_summary :
     * @return: xyz.ruankun.laughingspork.entity.SxReport
     */
    SxReport stage1_summary(SxStudent sxStudent, String stage1_summary, String stage1GuideWay, String stage1GuideDate);

    SxReport stage2_summary(SxStudent sxStudent, String stage2_summary, String stage2GuideWay, String stage2GuideDate);

    SxStudent findByStuNo(String StuNo);

    /**
     * 验证老师是否有权操作学生
     *
     * @param tNo   :
     * @param stuNO :
     * @return: java.lang.Boolean
     */
    Boolean testAuth(String tNo, String stuNO);
}

