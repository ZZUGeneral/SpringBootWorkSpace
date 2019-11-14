package com.yhl.test.mybatis_plus.service.impl;

import com.yhl.test.mybatis_plus.entity.User;
import com.yhl.test.mybatis_plus.mapper.UserMapper;
import com.yhl.test.mybatis_plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YHL
 * @since 2019-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
