package com.yhl.test.outputfirst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhl.test.outputfirst.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 杨贺龙
 * @name UserMapper
 * @create 2019-11-27 10:34
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
