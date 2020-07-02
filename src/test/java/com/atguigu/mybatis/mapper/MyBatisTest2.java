package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.mapper.bean.Department;
import com.atguigu.mybatis.mapper.bean.Employee;
import com.atguigu.mybatis.mapper.dao.DepartmentMapper;
import com.atguigu.mybatis.mapper.dao.EmployeeMapper;
import com.atguigu.mybatis.mapper.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MyBatisTest2 {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empById = mapper.getEmpById(4);
            System.out.println(empById);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empAndDept = mapper.getEmpAndDept(6);
            System.out.println(empAndDept);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empByStep = mapper.getEmpByStep(6);
            System.out.println(empByStep);
            System.out.println(empByStep.getDept());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empByStep = mapper.getEmpByStep(3);
            System.out.println(empByStep);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department deptByIdPlus = mapper.getDeptByIdPlus(2);
            System.out.println(deptByIdPlus);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department deptByIdStep = mapper.getDeptByIdStep(2);
            System.out.println(deptByIdStep.getDepartmentName());
        }finally {
            sqlSession.close();
        }
    }
}
