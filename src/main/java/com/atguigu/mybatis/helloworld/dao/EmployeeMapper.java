package com.atguigu.mybatis.helloworld.dao;

import com.atguigu.mybatis.helloworld.bean.Employee;

/**
 * @author zhanghao
 * @date 2020/6/30 - 19:09
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
