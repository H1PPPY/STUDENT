package com.pctc.test;

import com.pctc.Vo.WorkerFactorVo;
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
public class TestFactor {
    private SqlSession session;

    @Before
    public void read() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void testGetFactorId1() {
        FactorMapper mapper = session.getMapper(FactorMapper.class);
        Factor factorId1 = mapper.getFactorId1(3);
        System.out.println(factorId1);
    }

    @Test
    public void testGetFactorId2() {
        FactorMapper mapper = session.getMapper(FactorMapper.class);
        Factor fa = mapper.getFactorId2(1);
        System.out.println(fa);
    }

    @Test
    public void testFactorVoById() {
        FactorMapper mapper = session.getMapper(FactorMapper.class);
        List<WorkerFactorVo> factorVoById = mapper.getFactorVoById(1);
        for (WorkerFactorVo workerFactorVo : factorVoById) {
            System.out.println(workerFactorVo.getId() + "\t\t" + workerFactorVo.getName() + "\t\t" + workerFactorVo.getAge() + "\t\t" + workerFactorVo.getBirthDate() + "\t\t" + workerFactorVo.getFactoryName());
        }
    }
}

