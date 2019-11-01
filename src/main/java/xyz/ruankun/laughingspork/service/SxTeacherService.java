package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;

import java.util.List;

public interface SxTeacherService {

/**
 * 这是学生教师接口
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
     * 通过学号给学生写意见和打分
     * @param stuNo :
     * @param score :
     * @return: xyz.ruankun.laughingspork.entity.SxIdentifyForm
     */
    SxIdentifyForm fillIndentifyAdvice(String stuNo,String score);

    /**
     * findByTeacherNo
     * @param teacherNo :
     * @return: xyz.ruankun.laughingspork.entity.SxTeacher
     */
    SxTeacher findByTeacherNo(String teacherNo);


    void save(SxTeacher sxTeacher);
}
