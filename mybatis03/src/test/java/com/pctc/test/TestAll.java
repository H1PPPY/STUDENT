package com.pctc.test;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import com.pctc.vo.WorkerFactorVo;
import com.pctc.dao.FactorMapper;

import com.pctc.model.Factor;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/23 11:38
 */
public class TestAll {
    private SqlSession session;

    @Before
    public void read() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }
    @Test
    public void testGetFactorId(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = mapper.getWorkerId(2);
        System.out.println(worker.getId()+"\t"+worker.getName()+"\t"+worker.getAge()+"\t"+worker.getBirthday()+"\t"+worker.getFactor().getFactorName());
    }
    @Test
    public void testGetFactorById(){
        FactorMapper mapper = session.getMapper(FactorMapper.class);
        Factor factor = mapper.getFactorById(2);
        System.out.println(factor.getId()+"\t"+factor.getFactorName());
        for (Worker worker : factor.getWorkers()) {
            System.out.println(worker.getId()+"\t"+worker.getName()+"\t"+worker.getAge()+"\t"+worker.getBirthday());
        }
    }

    @Test
    public void testGetWorkerByVoId(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        WorkerFactorVo workerFactorVo = mapper.getWorkerByVoId(1);
        System.out.println(workerFactorVo);
    }

    @Test
    public void testGetFactorByVoId(){
        FactorMapper mapper = session.getMapper(FactorMapper.class);
        List<WorkerFactorVo> factor = mapper.getFactorByVoId(2);
        System.out.println(factor);
    }







}

