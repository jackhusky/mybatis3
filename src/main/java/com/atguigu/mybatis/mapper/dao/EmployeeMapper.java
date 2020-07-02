package com.atguigu.mybatis.mapper.dao;

import com.atguigu.mybatis.mapper.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghao
 * @date 2020/6/30 - 19:09
 */
public interface EmployeeMapper {

    //多条记录封装一个map
    @MapKey("id")
    public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    // 返回一条记录的map
    public Map<String,Object> getEmpsByIdReturnMap(Integer id);

    public List<Employee> getEmpsByLastName(String lastName);

    public Employee getEmpByMap(Map<String,Object> map);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    public Employee getEmpById(Integer id);

    public Long addEmp(Employee employee);

    public Boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
