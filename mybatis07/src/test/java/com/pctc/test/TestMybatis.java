package com.pctc.test;

import com.pctc.dao.StudentMapper;
import com.pctc.model.Student;
import com.pctc.model.StudentExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author H1PPPY
 * @date 2021/9/27 11:22
 */
public class TestMybatis {
    private InputStream inputStream;
    private SqlSession session;

    @Before
    public void read() throws Exception {
        inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.session = sqlSessionFactory.openSession();
    }

    @Test
    public void TestGetStudent1() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        //1.查询所有
        /*StudentExample example = null;
        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.gettId()+"\t"+student.gettName()+"\t"+student.gettAge());
            }*/

        //2.单个条件查询
        /*StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andTAgeGreaterThan(new Integer("22"));

        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.gettId()+"\t"+student.gettName()+"\t"+student.gettAge());
        }*/

        //多条件查询and:
        /*StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andTAgeGreaterThan(new Integer("22"));
        criteria.andTNameLike("%温%");

        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.gettId()+"\t"+student.gettName()+"\t"+student.gettAge());
        }*/

        //多条件查询or:
        /*StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andTAgeGreaterThan(new Integer("22"));
        criteria.andTNameLike("%温%");

        StudentExample.Criteria criteria1 = example.createCriteria();
        criteria1.andTIdLessThanOrEqualTo(new Integer("2"));

        example.or(criteria1);//两个条件只需满足一个

        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.gettId()+"\t"+student.gettName()+"\t"+student.gettAge());
        }*/

        //5.排序
        /*StudentExample example = new StudentExample();
        example.setOrderByClause("t_age asc");//按年龄升序
        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student.gettId()+"\t"+student.gettName()+"\t"+student.gettAge());
        }*/

        //6.统计
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();

        criteria.andTAgeGreaterThanOrEqualTo(new Integer("22"));

        int count = mapper.countByExample(example);
        System.out.println(count);
    }
}

