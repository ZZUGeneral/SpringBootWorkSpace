package com.yhl.test.mybatis_plus.test_third.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author 杨贺龙
 * @name MyBaseMapper
 * @create 2019-11-25 9:46
 * @description:
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    List<T> findAll();
}