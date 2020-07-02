package com.atguigu.mybatis.dynamicsql;

import com.atguigu.mybatis.dynamicsql.bean.Employee;
import com.atguigu.mybatis.dynamicsql.dao.EmployeeMapperDynamic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanghao
 * @date 2020/6/30 - 19:14
 */
public class MyBaitsTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "dynamicsql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,"%e%",null,null);
            List<Employee> empsByConditionIf = mapper.getEmpsByConditionIf(employee);
            System.out.println(empsByConditionIf);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,"%e%",null,null);
            List<Employee> empsByConditionTrim = mapper.getEmpsByConditionTrim(employee);
            System.out.println(empsByConditionTrim);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,null,null,null);
            List<Employee> empsByConditionChoose = mapper.getEmpsByConditionChoose(employee);
            System.out.println(empsByConditionChoose);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(6,"jack","jack@163.com","1");
            mapper.updateEmp(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            List<Employee> empsByConditionForeach = mapper.getEmpsByConditionForeach(Arrays.asList(3, 4, 5, 6, 7));
            System.out.println(empsByConditionForeach);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,"lily","lily@163.com","1");
            Employee employee2 = new Employee(null,"lily","lily@163.com","1");
            Employee employee3 = new Employee(null,"lily","lily@163.com","1");
            mapper.addEmps(Arrays.asList(employee,employee2,employee3));
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test7(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,"e",null,null);
            List<Employee> empsTestInnerParameter = mapper.getEmpsTestInnerParameter(employee);
            System.out.println(empsTestInnerParameter);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test8(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
            Employee employee = new Employee(null,"jack","jack@126.com","1");
            mapper.addEmp(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
}
