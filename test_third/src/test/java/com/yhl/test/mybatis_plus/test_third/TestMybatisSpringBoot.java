package com.yhl.test.mybatis_plus.test_third;

import com.yhl.test.mybatis_plus.test_third.entity.User;
import com.yhl.test.mybatis_plus.test_third.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 杨贺龙
 * @name TestMybatisSpringBoot
 * @create 2019-11-14 16:38
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(20);
        user.setEmail("test@itcast.cn");
        user.setName("曹操");
        user.setUserName("caocao");
        user.setPassword("123456");
        int result = this.userMapper.insert(user); //返回的result是受影响的行数，并不是自增后的id
        System.out.println("result = > " + result);
        System.out.println("id = > "+user.getId()); //自增后的id会回填到对象中
    }


}
