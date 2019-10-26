package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import java.util.List;

/**
 * 实习单位指导老师服务接口
 *
 * @author lck
 */
public interface SxCorpTeacherService {

    /**
     * 实习单位指导老师注册
     *
     * @param sxCorpTeacher :
     * @return: void
     */
    void save(SxCorpTeacher sxCorpTeacher);

    /**
     * 获得学生列表
     *
     * @param sxCorpTeacher
     * @return
     */
    public List<SxStudent> getOwnedStudentsList(SxCorpTeacher sxCorpTeacher);

    /**
     * 获得学生实习鉴定表
     *
     * @param stuNo
     * @return
     */
    public SxIdentifyForm getIdentifyFormByStuId(String stuNo);

    /**
     * 操作实习鉴定表
     *
     * @param stuNo
     * @param teacherOpinion
     * @param teacherScore
     * @return
     */
    public SxIdentifyForm operateIdentifyForm(String stuNo, String teacherOpinion, String teacherScore, String teacherGrade);

    /**
     * 根据账号查找校外导师
     *
     * @param account : 账号
     * @return: xyz.ruankun.laughingspork.entity.SxCorpTeacher
     */
    SxCorpTeacher findByAccount(String account);
}
