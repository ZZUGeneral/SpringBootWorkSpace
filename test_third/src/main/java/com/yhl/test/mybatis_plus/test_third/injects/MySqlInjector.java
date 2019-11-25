package com.yhl.test.mybatis_plus.test_third.injects;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨贺龙
 * @name MySqlInjector
 * @create 2019-11-25 9:49
 * @description:
 */
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> list = super.getMethodList();
        list.add(new FindAll());
        return list;
    }
}
