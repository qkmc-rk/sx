package xyz.ruankun.laughingspork.service;

import io.swagger.models.auth.In;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;

import java.util.List;

public interface SxTeacherService {

/**
 * 这是教师接口
 * @param sxTeacher :
 * @return: java.util.List<xyz.ruankun.laughingspork.entity.SxStudent>
 */

    /**
     * 返回这个老师所带的学生列表信息
     * @param sxTeacher :
     * @return: java.util.List<xyz.ruankun.laughingspork.entity.SxStudent>
     */
    List<SxStudent> getStudentListByTeacherNo(SxTeacher sxTeacher);

    /**
     * 判断教师填写鉴定表状态
     * @return Boolean
     */
    Integer isIdentifyFlag(SxStudent sxStudent);

    /**
     * 判断教师填写报告状态
     * @return Boolean
     */
    Integer isReportFlag(SxStudent sxStudent);

    /**
     * 学生填写鉴定表状态
     * @param sxStudent
     * @return
     */
    Integer isIdentifyFilledFlag(SxStudent sxStudent);

    /**
     * 学生填写报告状态
     * @param sxStudent
     * @return
     */
    Integer isReportFilledFlag(SxStudent sxStudent);

    /**
     * findByTeacherNo
     * @param teacherNo :
     * @return: xyz.ruankun.laughingspork.entity.SxTeacher
     */
    SxTeacher findByTeacherNo(String teacherNo);

    SxReport saveReport1(String stuNo, String stage1_comment, String stage1_grade);

    SxReport saveReport2(String stuNo, String stage2_comment, String stage2_grade);
}
