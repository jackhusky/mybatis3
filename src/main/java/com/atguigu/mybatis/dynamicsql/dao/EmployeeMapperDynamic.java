package com.atguigu.mybatis.dynamicsql.dao;

import com.atguigu.mybatis.dynamicsql.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface EmployeeMapperDynamic {

    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);

    public void addEmps(@Param("emps")List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);

    public void addEmp(Employee emp);
}
