package com.pctc.Vo;

import java.util.Date;

/**
 * @author bantang13
 * @date 2021/9/24 9:01
 */
public class WorkerFactorVo {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthDate;
    private String factoryName;

    public WorkerFactorVo() {
    }

    public WorkerFactorVo(Integer id, String name, Integer age, Date birthDate, String factoryName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.factoryName = factoryName;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString() {
        return "WorkerFactorVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", factoryName='" + factoryName + '\'' +
                '}';
    }
}
