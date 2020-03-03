package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;

import javax.swing.text.html.parser.Entity;

public interface SxIdentifyFormService {


    /**
     * 查找鉴定表内容
     *
     * @param stuNo :
     * @return: xyz.ruankun.laughingspork.entity.SxIdentifyForm
     */
    SxIdentifyForm getIdentifyInfo(String stuNo);

    SxIdentifyForm saveIdentifyForm(SxIdentifyForm sxIdentifyForm);
}
