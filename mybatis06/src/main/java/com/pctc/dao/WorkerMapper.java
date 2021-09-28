package com.pctc.dao;

import com.pctc.model.Worker;

import java.util.List;
import java.util.Map;

/**
 * @author H1PPPY
 * @date 2021/9/26 19:28
 */
public interface WorkerMapper {

    /**
     * Select work bypage list.
     * 不使用mybatis分页查询插件,自定义查询
     * @param map the map
     * @return the list
     */
    public List<Worker> selectWorkerByPage(Map<String,Object> map);

    /**
     * Select worker by page plug list.
     * 使用mybatis分页插件,自定义分页
     * @param worker the worker
     * @return the list
     */
    public List<Worker> selectWorkerByPagePlug(Worker worker);
}
