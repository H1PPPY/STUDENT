package com.pctc.dao;

import com.pctc.model.Factor;

import com.pctc.vo.WorkerFactorVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author H1PPPY
 * @date 2021/9/24 16:51
 */
public interface FactorMapper {

    /**
     * Gets factor id.
     * 根据id查询工厂，不包括工人信息
     * @param id the id
     * @return the factor id
     */
    @Select("select * from factor where t_id = #{id}")
    @Results({@Result(property = "id",column = "t_id")
              ,@Result(property = "factorName",column = "t_factorname")})
    public Factor getFactorId(Integer id);

    /**
     * Gets factor by id.
     * 通过工人id来查询工人的所有信息包括工厂名  分布查询
     * @param id the id
     * @return the factor by id
     */
    @Select("select * from factor where t_id=#{id}")
    @Results({@Result(property = "id",column = "t_id")
            ,@Result(property = "factorName",column = "t_factorname")
            ,@Result(property = "workers",column = "t_id",many = @Many(select = "com.pctc.dao.WorkerMapper.getWorkerById",fetchType = FetchType.LAZY))
    })
    public Factor getFactorById(Integer id);

    @Select("select a.*,b.t_id as t_id1,b.t_factorname as fname from worker a,factor b where a.t_fid=b.t_id and b.t_id=#{id} ")
    @Results({

            @Result(property = "id",column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthDate",column = "t_birthday"),
            @Result(property = "factoryName",column = "fname")

    })
    public List<WorkerFactorVo> getFactorByVoId(Integer id);
}
