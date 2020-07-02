package com.atguigu.mybatis.mapper.dao;

import com.atguigu.mybatis.mapper.bean.Employee;

import java.util.List;

/**
 * @author zhanghao
 * @date 2020/7/1 - 9:20
 */
public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByStep(Integer id);

    public List<Employee> getEmpsByDeptId(Integer deptId);
}
