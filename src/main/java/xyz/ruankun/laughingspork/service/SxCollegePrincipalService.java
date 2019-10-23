package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxCollegePrincipal;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import java.util.List;

/**
 * 学院负责人服务接口
 * @author lck
 */
public interface SxCollegePrincipalService {
    /**
     * 查看学生列表
     * @param sxCollegePrincipal
     * @return
     */
    public List<SxStudent> getOwnedStudentsList(SxCollegePrincipal sxCollegePrincipal);

    /**
     * 查看实习鉴定表
     * @param stuNo
     * @return
     */
    public SxIdentifyForm getIdentifyFormByStuId(String stuNo);

    /**
     * 操作鉴定表
     * @param collegePrincipalOpinion
     * @param comprehsvGrade
     * @return
     */
    public SxIdentifyForm operateIdentifyForm(String stuNo,String collegePrincipalOpinion,String comprehsvGrade);
}
