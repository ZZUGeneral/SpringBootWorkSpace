package com.example.demo.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author YHL
 * @title: JedisTest
 * @projectName output-first
 * @description: TODO
 * @date 2020/7/722:01
 */
public class JedisTest {

    @Test
    public void testJedis() {
        //连接Redis
        Jedis jedis = new Jedis("192.168.18.100", 6379);
        // 操作Redis
        jedis.set("name", "yhl");
        String val = jedis.get("name");
        System.out.println("============" + val);
        //关闭连接
        jedis.close();
    }
}
