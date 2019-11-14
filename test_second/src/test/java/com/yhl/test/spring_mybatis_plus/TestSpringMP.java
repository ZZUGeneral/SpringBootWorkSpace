package com.yhl.test.spring_mybatis_plus;

import com.yhl.test.spring_mybatis_plus.entity.User;
import com.yhl.test.spring_mybatis_plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 杨贺龙
 * @name TestSpringMP
 * @create 2019-11-14 16:18
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringMP {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = this.userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
