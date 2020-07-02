package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.mapper.bean.Employee;
import com.atguigu.mybatis.mapper.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghao
 * @date 2020/6/30 - 19:14
 */
public class MyBaitsTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 测试增删改查
     */
    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee("tom","tom@163.com","0");
            mapper.addEmp(employee);
            System.out.println(employee.getId());
//            Employee employee = new Employee(3,"jerry","jerry@163.com","1");
//            Boolean aBoolean = mapper.updateEmp(employee);
//            System.out.println(aBoolean);
//            mapper.deleteEmpById(1);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 测试多参数
     */
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee jerry = mapper.getEmpByIdAndLastName(3, "jerry");
            System.out.println(jerry);
//            Map<String, Object> map = new HashMap<>();
//            map.put("id",4);
//            map.put("lastName","jerry");
//            Employee empByMap = mapper.getEmpByMap(map);
//            System.out.println(empByMap);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 测试返回list,map
     */
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            /*List<Employee> empsByLastName = mapper.getEmpsByLastName("%e%");
            for (Employee employee : empsByLastName) {
                System.out.println(employee);
            }*/
            /*Map<String, Object> map = mapper.getEmpsByIdReturnMap(4);
            System.out.println(map);*/
            Map<Integer, Employee> returnMap = mapper.getEmpByLastNameLikeReturnMap("%e%");
            System.out.println(returnMap);
        }finally {
            sqlSession.close();
        }
    }

}
