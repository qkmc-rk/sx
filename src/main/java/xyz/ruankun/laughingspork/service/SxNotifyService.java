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
}
