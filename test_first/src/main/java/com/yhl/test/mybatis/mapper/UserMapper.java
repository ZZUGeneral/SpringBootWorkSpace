package com.yhl.test.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhl.test.mybatis.entity.User;

import java.util.List;

/**
 * @author 杨贺龙
 * @name UserMapper
 * @create 2019-11-14 15:40
 * @description:
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}
