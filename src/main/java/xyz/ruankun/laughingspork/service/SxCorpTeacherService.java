package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import java.util.List;

/**
 * 实习单位指导老师服务接口
 * @author lck
 */
public interface SxCorpTeacherService {
    /**
     * 获得学生列表
     * @param sxCorpTeacher
     * @return
     */
    public List<SxStudent> getOwnedStudentsList(SxCorpTeacher sxCorpTeacher);

    /**
     * 获得学生实习鉴定表
     * @param sxStudent
     * @return
     */
    public SxIdentifyForm getIdentifyFormByStuId(SxStudent sxStudent);

    /**
     * 操作实习鉴定表
     * @param sxStudent
     * @param teacherOpinion
     * @param teacherScore
     * @return
     */
    public SxIdentifyForm operateIdentifyForm(SxStudent sxStudent, String teacherOpinion, String teacherScore,String teacherGrade);
}
