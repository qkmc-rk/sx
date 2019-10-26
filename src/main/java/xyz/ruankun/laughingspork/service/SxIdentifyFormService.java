package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

public interface SxIdentifyFormService {
    
    
/** 
 * 学生鉴定表接口
 * @param null : 
 * @return: 
 */
    
    /**
     * 查找鉴定表内容
     * @param stuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxIdentifyForm
     */
    SxIdentifyForm getIndentifyInfo(String stuNo);


}
