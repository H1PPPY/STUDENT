package com.pctc.dao;

import com.pctc.Vo.WorkerFactorVo;
import com.pctc.model.Factor;

import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/23 19:45
 */
public interface FactorMapper {

    /**
     * Gets factor id.
     *根据id查询学校
     * @param id the id
     * @return the factor id
     */
    public Factor getFactorId(Integer id);

    /**
     * Gets factor id 1.
     * 根据ID查询工厂并查出在这个工厂里的工人
     * @param id the id
     * @return the factor id 1
     */
    public Factor getFactorId1(Integer id);


    /**
     * Gets factor id 2.
     * 分步查询
     * @param id the id
     * @return the factor id 2
     */
    public Factor getFactorId2(Integer id);

    /**
     * Gets factor vo by id.
     * 新建一个实体类（Vo），将数据库中查询的数据与Vo中的属性一一对应
     * @param id the id
     * @return the factor vo by id
     */
    public List<WorkerFactorVo> getFactorVoById(Integer id);
}
