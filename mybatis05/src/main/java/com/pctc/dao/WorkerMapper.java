package com.pctc.dao;

import com.pctc.model.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author H1PPPY
 * @date 2021/9/25 20:45
 */
public interface WorkerMapper {
    /**
     * Gets workers.
     * 根据动态SQL语句条件查询
     * @param worker the worker
     * @return the workers
     */
    public List<Worker> getWorkers(Worker worker);
}
