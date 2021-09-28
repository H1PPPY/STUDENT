package com.pctc.test;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author H1PPPY
 * @date 2021/9/25 20:48
 */
public class TestWorker {

    private SqlSession session;
    private SqlSession session1;

    @Before
    public void read() throws Exception {
        // 构建mybatis的执行对象
//		FileInputStream fis = new FileInputStream("src/config.xml");
//		SqlSession session = new SqlSessionFactoryBuilder().build(fis)
//				.openSession();


        InputStream inputStream = Resources.getResourceAsStream("config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        session = sqlSessionFactory.openSession();

        session1 = sqlSessionFactory.openSession();
    }

    @Test
    public void testGetWorks() {

        /*测试一级缓存*/
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = new Worker();
        worker.setAge(22);
        List<Worker> workers = mapper.getWorkers(worker);
        System.out.println(workers);

        List<Worker> workers1 = mapper.getWorkers(worker);
        System.out.println(workers1);

        /*1.不同的SqlSession对应的不同的一级缓存,缓存失败*/
        /*2.同一个SqlSession但是查询条件不同,缓存失败*/
        /*3.同一个SqlSession两次查询期间执行了任何一次增删改操作,缓存失败*/
        /*4.同一个SqlSession两次查询期间手动清空了缓存session.clearCache(),缓存失败 :*/

    }

    //测试二级缓存,要同一个SqlSessionFactory,从里面得到不同的SqlSession,二级缓存就是SqlSession不同,SqlSession要关闭
    @Test
    public void testGetWorks1() {
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker = new Worker();
        worker.setName("%晏松%");
        List<Worker> workers = mapper.getWorkers(worker);
        System.out.println(workers);
        session.close();

        //!不同的session,一定要关闭, 不必然走的是一级缓存

        WorkerMapper mapper1 = session1.getMapper(WorkerMapper.class);
        List<Worker> workers1 = mapper1.getWorkers(worker);
        System.out.println(workers1);
        session.close();
    }

}

