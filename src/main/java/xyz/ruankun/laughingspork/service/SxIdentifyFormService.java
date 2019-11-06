package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import javax.swing.text.html.parser.Entity;

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
    SxIdentifyForm getIdentifyInfo(String stuNo);

    void saveIdentifyForm(SxIdentifyForm sxIdentifyForm);

}
