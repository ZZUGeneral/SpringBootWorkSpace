package com.example.demo.service;

import com.example.demo.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * @author YHL
 * @title: JedisService
 * @projectName output-first
 * @description: TODO
 * @date 2020/7/810:19
 */
public class JedisService {
    private String id;
    private int num;

    public JedisService(String id, int num) {
        this.id = id;
        this.num = num;
    }

    //控制单元
    public void service() {
        //Jedis jedis = new Jedis("192.168.18.100", 6379);
        Jedis jedis = JedisUtil.getJedis();
        String val = jedis.get("compid:" + id);
        //判断该值是否存在
        try {
            if (val == null) {
                //不存在，创建该值
                jedis.setex("compid:" + id, 20, Long.MAX_VALUE - num + "");
            } else {
                //存在，自增
                Long value = jedis.incr("compid:" + id);
                business(id, num - (Long.MAX_VALUE - value));
            }
        } catch (JedisDataException e) {
            System.out.println("用户：" + id + "使用次数已经达到次数上限，请升级会员使用");
        } finally {
            jedis.close();
        }
    }

    //业务操作
    public void business(String id, Long val) {
        System.out.println("用户：" + id + "业务执行第" + val + "次！！！");
    }
}

class MyThread extends Thread {
    JedisService service;

    public MyThread(String id, int num) {
        service = new JedisService(id, num);
    }

    @Override
    public void run() {
        while (true) {
            service.service();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("初级用户", 10);
        MyThread thread2 = new MyThread("高级用户", 30);
        thread1.start();
        thread2.start();
    }
}

