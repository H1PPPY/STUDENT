package com.pctc.dao;

import com.pctc.model.Worker;
import com.pctc.vo.WorkerFactorVo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/24 16:48
 */
public interface WorkerMapper {

    /**
     * Gets worker id.
     * 根据id查询工人，包括工人的工厂  分步查询
     * @param id the id
     * @return the worker id
     */
    @Select("select * from worker where t_id=#{id}")
    @Results({
            @Result(property = "id", column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthday",column = "t_birthday"),
            @Result(property = "factor",column = "t_fid",one = @One(select = "com.pctc.dao.FactorMapper.getFactorId",fetchType = FetchType.LAZY))

    })
    public Worker getWorkerId(Integer id);

    /**
     * Gets worker by id.
     * 通过工厂id来查询这个工厂的所有工人
     * @param fid the fid
     * @return the worker by id
     */
    @Select("select * from worker where t_fid = #{fid}")
    @Results({
            @Result(property = "id", column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthday",column = "t_birthday"),
    })
    public List<Worker> getWorkerById(Integer fid);

    @Select("select a.*,b.t_id as t_id1,b.t_factorname as fname from worker a,factor b where a.t_fid=b.t_id and a.t_id=#{id} ")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthDate",column = "t_birthday"),
            @Result(property = "factoryName",column = "fname")

    })
    public WorkerFactorVo getWorkerByVoId(Integer id);
}
