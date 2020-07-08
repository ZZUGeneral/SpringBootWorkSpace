package com.example.demo.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author YHL
 * @title: JedisUtil
 * @projectName output-first
 * @description: TODO
 * @date 2020/7/811:05
 */
public class JedisUtil {
    private static JedisPool jp = null;
    private static String host = null;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.port"));
        maxIdle = Integer.parseInt(rb.getString("redis.port"));
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(maxTotal);
        jpc.setMaxIdle(maxIdle);
        jp = new JedisPool(jpc, host, port);
    }

    public static Jedis getJedis() {
        return jp.getResource();
    }

    public static void main(String[] args) {
        JedisUtil.getJedis();
    }
}
