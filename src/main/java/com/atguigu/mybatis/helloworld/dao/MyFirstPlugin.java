package com.atguigu.mybatis.helloworld.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * @author zhanghao
 * @date 2020/7/2 - 11:13
 */
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method="parameterize",args=java.sql.Statement.class)
        })
public class MyFirstPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin...intercept:"+invocation.getMethod());
        //动态的改变一下sql运行的参数：以前4号员工，实际从数据库查询5号员工
        Object target = invocation.getTarget();
        System.out.println("当前拦截到的对象："+target);
        //拿到：StatementHandler==>ParameterHandler===>parameterObject
        //拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数是："+value);
        //修改完sql语句要用的参数
        metaObject.setValue("parameterHandler.parameterObject", 5);
        //执行目标方法
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin...plugin:mybatis将要包装的对象"+target);
        Object wrap = Plugin.wrap(target,this);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }
}
