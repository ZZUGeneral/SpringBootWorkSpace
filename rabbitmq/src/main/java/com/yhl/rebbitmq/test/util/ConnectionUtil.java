package com.yhl.rebbitmq.test.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yanghelong
 * @title: ConnectionUtil
 * @projectName output-first
 * @description: TODO
 * @date 2021/1/2011:25
 */
public class ConnectionUtil {

    //建立与 RabbitMq 的连接

    public static Connection getConnection() throws IOException, TimeoutException {
        // 连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        // 设置服务器地址
        factory.setHost("");

        // 端口
        factory.setPort(5672);

        // 设置账号信息，用户名，密码，vhost
        factory.setVirtualHost("/");
        factory.setUsername("");
        factory.setPassword("");

        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
