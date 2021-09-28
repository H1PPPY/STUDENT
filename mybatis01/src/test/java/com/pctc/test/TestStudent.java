package com.pctc.test;

import com.pctc.dao.StudentMapper;
import com.pctc.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/22 16:47
 */
public class TestStudent {
    private SqlSession session;

    @Before
    public void read() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        this.session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void testSelectStudent() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAllStudent();
        for (Student student : students) {
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge());
        }
    }

    @Test
    public void testSelectStudentById() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudentById(3);
        for (Student student : students) {
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge());
        }

    }

    @Test
    public void testSelectStudentByNameId(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("a","熊腾");
        map.put("b",22);
        List<Student> students = mapper.selectStudentByNameId(map);
        for (Student student : students) {
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge());
        }

    }

    @Test
    public void testCountStudentByAge(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int count = mapper.countAge(22);
        System.out.println(count);
    }

    @Test
    public void testInsertStudent(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("bantang13");
        student.setAge(23);
        int count = mapper.insertStudent(student);
        session.commit();
        System.out.println(count);
        session.close();
    }

    @Test
    public  void testDeleteStudent(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int count = mapper.deleteStudentByName("刘思浪");
        session.commit();
        System.out.println(count);
        session.close();
    }

    @Test
    public void updateStudentByName(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student("h1ppy",21);
        HashMap<String, Object> map = new HashMap<>();
        map.put("a",student);
        map.put("b","bantang13");
        int i = mapper.updateStudentByName(map);
        session.commit();
        System.out.println(i);
        session.close();
    }
}
