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
     * 条件查询
     * @param worker the worker
     * @return the workers
     */
    public List<Worker> getWorkers(Worker worker);

    /**
     * Gets workers 1.
     * 通过where t_id in (?,?,?)查询工人
     * @param list the list
     * @return the workers 1
     */
    public List<Worker> getWorkers1(@Param("list") List<Integer> list);

    /**
     * Update worker int.
     * 修改信息
     * @param worker the worker
     * @return the int
     */
    public int updateWorker(Worker worker);

    /**
     * Insert workers int.
     * 一次插入多个工人
     * @param list the list
     * @return the int
     */
    public int insertWorkers(List<Worker> list);
}
