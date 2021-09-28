package com.pctc.dao;

import com.pctc.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author bantang13
 * @date 2021/9/22 16:37
 */
public interface StudentMapper {

    /**
     * 查询所有用户
     * 通过注解的方式
     *
     * @return the list
     */
    @Select("select * from student")
    @Results({
            @Result(property = "id", column = "t_id")
            , @Result(property = "name", column = "t_name")
            , @Result(property = "age", column = "t_age")
    })
    public List<Student> selectAllStudent();


    /**
     * Select student by id list.
     * 通过ID查询  用注释的方法
     *
     * @param id the id
     * @return the list
     */
    @Select("select * from student where t_id > #{param1}")
    @Results({
            @Result(property = "id", column = "t_id")
            , @Result(property = "name", column = "t_name")
            , @Result(property = "age", column = "t_age")
    })
    public List<Student> selectStudentById(Integer id);

    /**
     * Select student by name id list.
     * 通过注释将多个参数封装进map
     *
     * @param map the map
     * @return the list
     */
    @Select("select t_id as id,t_name as name,t_age as age from student where t_name=#{a} and t_age=#{b}")
    public List<Student> selectStudentByNameId(Map<String, Object> map);

    /**
     * Count id int.
     * 通过年龄统计
     *
     * @param age the age
     * @return the int
     */
    @Select("select count(*) from student where t_age=#{param1}")
    public int countAge(Integer age);

    /**
     * Insert student int.
     * 增加学生
     *
     * @param student the student
     * @return the int
     */
    @Insert("insert into student (t_name,t_age) values (#{name},#{age})")
    public int insertStudent(Student student);

    /**
     * Delete student by name int.
     * 通过姓名删除
     *
     * @param name the name
     * @return the int
     */
    @Delete("delete from student where t_name = #{param1}")
    public int deleteStudentByName(String name);

    /**
     * Update student by name int.
     * 通过map传值修改学生信息
     * 学生通过姓名找到，用于测试，平常应该用id
     *
     * @param map the map
     * @return the int
     */
    @Update("update student set t_name=#{a.name},t_age=#{a.age} where t_name like #{b}")
    public int updateStudentByName(Map<String, Object> map);
}
