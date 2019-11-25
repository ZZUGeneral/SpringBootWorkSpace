package com.yhl.test.mybatis_plus.test_third.mapper;

import com.yhl.test.mybatis_plus.test_third.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 杨贺龙
 * @name UserMapper
 * @create 2019-11-14 16:36
 * @description:
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    User findById(Long id);
}
