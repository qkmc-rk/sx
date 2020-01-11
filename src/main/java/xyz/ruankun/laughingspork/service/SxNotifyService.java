package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxNotify;

import java.util.List;

public interface SxNotifyService {

    /**
     * 分页查找
     * @param page
     * @param limit
     * @return
     */
    List<SxNotify> findByPageAndLimit(int page, int limit);

    /**
     * 通过id查询SxNotify
     * @param id
     * @return
     */
    SxNotify findById(int id);

    /**
     * 赞一个通知
     * @param id
     */
    SxNotify praise(Integer id);

    /**
     * 踩一个通知
     * @param id
     * @return
     */
    SxNotify low(Integer id);
}
