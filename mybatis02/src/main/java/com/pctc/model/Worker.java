package com.pctc.model;

import java.util.Date;

/**
 * @author bantang13
 * @date 2021/9/23 10:47
 */
public class Worker {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private Factor factor;

    public Worker() {
    }

    public Worker(Integer id, String name, Integer age, Date brithday, Factor factor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = brithday;
        this.factor = factor;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date brithday) {
        this.birthday = brithday;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", factor=" + factor +
                '}';
    }
}
