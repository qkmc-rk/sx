package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxCorp;
import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import java.util.List;

/**
 * 单位负责人服务接口
 * @author lck
 */
public interface SxCorpService {
    /**
     * 获得学生列表
     * @param sxCorp
     * @return
     */
    public List<SxStudent> getOwnedStudentsList(SxCorp sxCorp);

    /**
     * 查看学生鉴定表
     * @param stuNo
     * @return
     */
    public SxIdentifyForm getIdentifyFormByStuId(String stuNo);

    /**
     * 实习单位意见
     * @param stuNo
     * @param corpOpinion
     * @return
     */
    public SxIdentifyForm operateIdentifyForm(String stuNo, String corpOpinion);

}
