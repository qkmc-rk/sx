package xyz.ruankun.laughingspork.service;

import io.swagger.models.auth.In;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;

import java.util.List;

public interface SxTeacherService {


    /**
     * 返回这个老师所带的学生列表信息
     *
     * @param sxTeacher :
     * @return: java.util.List<xyz.ruankun.laughingspork.entity.SxStudent>
     */
    List<SxStudent> getStudentListByTeacherNo(SxTeacher sxTeacher);


    /**
     * findByTeacherNo
     *
     * @param teacherNo :
     * @return: xyz.ruankun.laughingspork.entity.SxTeacher
     */
    SxTeacher findByTeacherNo(String teacherNo);

    void save(SxTeacher sxTeacher);

    SxReport saveReport1(String stuNo, String stage1_comment, String stage1_grade);

    SxReport saveReport2(String stuNo, String stage2_comment, String stage2_grade);

}
