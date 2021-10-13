package com.pctc.test;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author H1PPPY
 * @date 2021/9/25 20:48
 */
public class TestWorker {

    private SqlSession session;
    @Before
    public void read() throws Exception {
        // 构建mybatis的执行对象
//		FileInputStream fis = new FileInputStream("src/config.xml");
//		SqlSession session = new SqlSessionFactoryBuilder().build(fis)
//				.openSession();

        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void testGetWorks(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = new Worker();
        worker.setId(1);
        /*worker.setAge(22);
        worker.setName("%熊腾%");*/
        List<Worker> workers = mapper.getWorkers(worker);
        System.out.println(workers);
    }

    @Test
    public void testUpdateWorker(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = new Worker();
        worker.setName("hippy");
        worker.setAge(100);
        worker.setId(1);
        int i = mapper.updateWorker(worker);
        session.commit();
        System.out.println(i);
        session.close();

    }

    @Test
     public void testGetWorkers1(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Worker> workers1 = mapper.getWorkers1(list);
        System.out.println(workers1);
    }

    @Test
    public void testInsertWorkers(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker1 = new Worker();
        worker1.setName("熊海波");
        worker1.setAge(24);

        Worker worker2 = new Worker();
        worker2.setName("徐志勇");
        worker2.setAge(26);
        List<Worker> list = new ArrayList<>();
        list.add(worker1);
        list.add(worker2);
        int i = mapper.insertWorkers(list);
        session.commit();
        System.out.println(i);
        session.close();

    }

}
