package com.yhl.test.mybatis;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.yhl.test.mybatis.entity.User;
import com.yhl.test.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 杨贺龙
 * @name TestMybatis
 * @create 2019-11-14 15:44
 * @description:
 */
public class TestMybatisPlus {

    @Test
    public void testUserList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // List<User> list = userMapper.findAll();
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
