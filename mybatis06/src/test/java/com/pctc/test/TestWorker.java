package com.pctc.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author H1PPPY
 * @date 2021/9/26 19:52
 */
public class TestWorker {
    private SqlSession session;

    @Before
    public void read() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void testSelectWorkerByPage() {
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Map<String, Object> map = new HashMap<>();
        int page = 2;
        int number = 3;
        map.put("recordNum", (page - 1) * number);
        map.put("pageSize", number);
        List<Worker> workers = mapper.selectWorkerByPage(map);
        for (Worker worker : workers) {
            System.out.println(worker.getId() + "\t" + worker.getName() + "\t" + worker.getAge() + "\t" + worker.getBirthday());
        }

    }

    //分页查询  简单
    @Test
    public void testSelectWorkerByPageWithPlug(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);

        Worker worker1 = new Worker();

        int pageNum=1;
        int pageSize=3;
        //放在查询前
        Page<Worker> page = PageHelper.startPage(pageNum,pageSize);

        List<Worker> workers = mapper.selectWorkerByPagePlug(worker1);

        for (Worker worker : workers) {
            System.out.println(worker.getId() + "\t" + worker.getName() + "\t" + worker.getAge() + "\t" + worker.getBirthday());
        }

        System.out.println("当前页码:"+page.getPageNum());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("每页的记录数:"+page.getPageSize());
        System.out.println("总页数:"+page.getPages());


    }

    @Test
    public void testSelectWorkerByPageWithPlugComplex(){
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);

        Worker worker1 = new Worker();

        int pageNum=2;
        int pageSize=3;
        //放在查询前
        Page<Worker> page = PageHelper.startPage(pageNum,pageSize);

        List<Worker> workers = mapper.selectWorkerByPagePlug(worker1);

        PageInfo<Worker> info = new PageInfo<>(workers,3);
        for (Worker worker : workers) {
            System.out.println(worker.getId() + "\t" + worker.getName() + "\t" + worker.getAge() + "\t" + worker.getBirthday());
        }

        System.out.println("当前页码:"+page.getPageNum());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("每页的记录数:"+page.getPageSize());
        System.out.println("总页数:"+page.getPages());
        System.out.println("连续显示的页码:");
        int[] nums = info.getNavigatepageNums();
        for (int num : nums) {
            System.out.println(num);
        }


    }

}



