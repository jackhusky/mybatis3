package com.atguigu.mybatis.mapper.dao;

import com.atguigu.mybatis.mapper.bean.Department;

/**
 * @author zhanghao
 * @date 2020/7/1 - 10:17
 */
public interface DepartmentMapper {

    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);
}
