package com.yhl.test.mybatis_plus.test_third;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhl.test.mybatis_plus.test_third.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author 杨贺龙
 * @name TestActiveRecord
 * @create 2019-11-22 15:56
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActiveRecord {

    @Test
    public void tesSelectById(){
        User user = new User();
        user.setId(2L);
        User user1 = user.selectById();
        System.out.println(user1);
    }
    @Test
    public void tesSelect(){
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age",30);
        List<User> userList = user.selectList(wrapper);
        for(User user1: userList)
            System.out.println(user1);
    }
    @Test
    public void tesInsert(){
        User user = new User();
        user.setUserName("liubei");
        user.setPassword("123455");
        user.setAge(24);
        user.setName("刘备");
        user.setMail("123456@it.com");
        boolean insert = user.insert();
        System.out.println(insert);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(8L);
        user.setAge(31);
        boolean update = user.updateById();
        System.out.println(update);
    }
    @Test
    public void testDelete(){
        User user = new User();
        user.setId(8L);
        boolean delete = user.deleteById();
        System.out.println(delete);
    }

}
