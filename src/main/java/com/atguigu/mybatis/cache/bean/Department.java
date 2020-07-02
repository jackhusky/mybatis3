package com.atguigu.mybatis.cache.bean;

import java.util.List;

/**
 * @author zhanghao
 * @date 2020/7/1 - 9:29
 */
public class Department {

    private Integer id;
    private String departmentName;
    private List<Employee> emps;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
