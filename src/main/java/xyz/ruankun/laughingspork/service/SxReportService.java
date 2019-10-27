package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxReport;


public interface SxReportService {
    
/** 
 * 学生报告册服务接口
 * @param null : 
 * @return:
 */

    /**
     * 查找报告内容
     * @param stuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxReport
     */
    SxReport getReportInfo(String stuNo);

}
