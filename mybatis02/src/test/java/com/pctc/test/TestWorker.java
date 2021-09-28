package com.pctc.test;

import com.pctc.Vo.WorkerFactorVo;
import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
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
public class TestWorker {
    private SqlSession session;

    @Before
    public void read() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void testGetWorkerById(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = mapper.getWorkerById2(2);
        System.out.println(worker.getName());
        System.out.println(worker.getFactor());
    }

    @Test
    public void testGetWorkerById1(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = mapper.getWorkerById1(1);
        System.out.println(worker);
    }

    @Test
    public void testWorkerVoById(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        WorkerFactorVo workerVoById = mapper.getWorkerVoById(2);
        System.out.println(workerVoById);

    }


}
