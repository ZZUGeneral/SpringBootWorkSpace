package com.yhl.test.mybatis_plus.test_third;

import com.yhl.test.mybatis_plus.test_third.entity.User;
import com.yhl.test.mybatis_plus.test_third.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 杨贺龙
 * @name TestMyMapper
 * @create 2019-11-25 10:15
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMyMapper {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> users = this.userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
