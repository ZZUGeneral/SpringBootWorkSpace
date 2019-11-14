package com.yhl.test.mybatis.mapper;

import com.yhl.test.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 杨贺龙
 * @name UserMapper
 * @create 2019-11-12 17:30
 * @description:
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
