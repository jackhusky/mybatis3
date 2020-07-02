package com.atguigu.mybatis.other;

import com.atguigu.mybatis.other.bean.Employee;
import com.atguigu.mybatis.other.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class MyBaitsTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        String resource = "other/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Page<Object> page = PageHelper.startPage(5, 1);

            List<Employee> emps = mapper.getEmps();
            //传入要连续显示多少页
            PageInfo<Employee> info = new PageInfo<>(emps, 5);
            System.out.println("当前页码："+info.getPageNum());
            System.out.println("总记录数："+info.getTotal());
            System.out.println("每页的记录数："+info.getPageSize());
            System.out.println("总页码："+info.getPages());
            System.out.println("是否第一页："+info.isIsFirstPage());
            System.out.println("连续显示的页码：");
            int[] nums = info.getNavigatepageNums();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testBatch() throws IOException{

        //可以执行批量操作的sqlSession
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        long start = System.currentTimeMillis();
        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            for (int i = 0; i < 10000; i++) {
                mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0, 5), "b", "1"));
            }
            openSession.commit();
            long end = System.currentTimeMillis();
            System.out.println("执行时长："+(end-start));
        }finally{
            openSession.close();
        }

    }
}
