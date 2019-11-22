package com.yhl.test.mybatis_plus.test_third.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhl.test.mybatis_plus.test_third.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 杨贺龙
 * @name UserMapper
 * @create 2019-11-14 16:36
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User findById(Long id);
}
