package com.atguigu.mybatis.other.dao;


import com.atguigu.mybatis.other.bean.Employee;

import java.util.List;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

    public Long addEmp(Employee employee);
}
