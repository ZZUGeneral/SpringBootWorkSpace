package com.yhl.test.mybatis_plus.test_third.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * @author 杨贺龙
 * @name MyInterceptor
 * @create 2019-11-25 9:00
 * @description:
 */
@Intercepts(value = {@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
    //拦截方法，具体业务逻辑编写的位置
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
    //创建target对象的代理对象,目的是将当前拦截器加入到该对象中
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    //属性设置
    }
    /**
     * 自定义拦截器
     */
    @Bean //注入自定义拦截器
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}