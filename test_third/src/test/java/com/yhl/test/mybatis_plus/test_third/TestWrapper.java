package com.yhl.test.mybatis_plus.test_third;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhl.test.mybatis_plus.test_third.entity.User;
import com.yhl.test.mybatis_plus.test_third.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨贺龙
 * @name TestWrapper
 * @create 2019-11-22 14:55
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWrapper {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testAllEq() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "lisi");
        params.put("age", "20");
        params.put("password", null);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //wrapper.allEq(params,false);
        wrapper.allEq((k, v) -> (k.equals("age") || k.equals("id") || k.equals("name ")), params);
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void testEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123456")
                .ge("age", 20)
                .in("name", "李四", "王五", "赵六");
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testLike() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeLeft("name", "李四");
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testOrderByAgeDesc() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testOr() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "王五")
                .or().eq("age", 20);
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "王五")
                .or().eq("age", 20)
                .select("id", "name", "age");
        List<User> userList = this.userMapper.selectList(wrapper);

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateAll() {
        User user = new User();
        user.setAge(31);
        boolean result = user.update(null);
        System.out.println("Result = >" + result);
    }
}

