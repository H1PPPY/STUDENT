package com.pctc.dao;

import com.pctc.Vo.WorkerFactorVo;
import com.pctc.model.Worker;

import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/23 10:56
 */
public interface WorkerMapper {

    /**
     * Gets worker by id.
     *根据id查询工人，包括工厂，连接查询
     * @param id the id
     * @return the worker by id
     */
    public Worker getWorkerById(Integer id);

    /**
     * Gets worker by id 1.
     *根据id查询工人，包括工厂，连接查询
     * @return the worker by id 1
     */
    public Worker getWorkerById1(Integer id);

    /**
     * Gets worker by id 2.
     *分步查询
     * @param id the id
     * @return the worker by id 2
     */
    public Worker getWorkerById2(Integer id);


    /**
     * Gets workers by factor id.
     *
     * @param id the id
     * @return the workers by factor id
     */
    public List<Worker> getWorkersByFactorId(Integer id);

    /**
     * Gets worker vo by id.
     * 新建一个实体类（Vo），将数据库中查询的数据与Vo中的属性一一对应
     * @return the worker vo by id
     */
    public WorkerFactorVo getWorkerVoById(Integer id);

}
