package com.pctc.model;

import java.util.List;

/**
 * @author bantang13
 * @date 2021/9/23 10:53
 */
public class Factor {
    private Integer id;
    private String factorName;
    private List<Worker> Workers;

    public List<Worker> getWorkers() {
        return Workers;
    }

    public void setWorkers(List<Worker> workers) {
        Workers = workers;
    }

    public Factor() {

    }

    public Factor(Integer id, String factorName, List<Worker> workers) {
        this.id = id;
        this.factorName = factorName;
        Workers = workers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    @Override
    public String toString() {
        return "Factor{" +
                "id=" + id +
                ", factorName='" + factorName + '\'' +
                ", Workers=" + Workers +
                '}';
    }
}
