package com.yhl.test.activemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

/**
 * @author YHL
 * @title: TopicPersistentTest
 * @projectName output-first
 * @description: TODO
 * @date 2020/6/2118:55
 */
public class TopicPersistentTest {
    //编写消息发送方 ---生产者
    @Test
    public void test1() throws JMSException {
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.18.100:61616");
        //从工厂中获取一个链接对象
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("cleint-2");
        //连接MQ服务
        connection.start();
        //获取session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //通过session对象创建Topic
        Topic topic = session.createTopic("yhlTopic");
        //通过session对象创建消息的发送者
        MessageProducer producer = session.createProducer(topic);
        //通过session创建消息对象
        TextMessage message = session.createTextMessage("ping");
        //发送消息
        producer.send(message, DeliveryMode.PERSISTENT, 1, 1000 * 60 * 60 * 24);
        System.out.println("生产者发送了消息:" + message.getText());
        //关闭相关资源
        producer.close();
        session.close();
        connection.close();

    }

    //编写消息接受方 ---消费者
    @Test
    public void test2() throws JMSException {
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.18.100:61616");
        //从工厂中获取一个链接对象
        Connection connection = connectionFactory.createConnection();
        //设置客户端ID
        connection.setClientID("client-1");
        //连接MQ服务
        connection.start();
        //获取session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //通过session对象创建Topic
        Topic topic = session.createTopic("yhlTopic");
        //通过session对象创建消息r的发送者
        //MessageConsumer consumer = session.createConsumer(topic);
        //客户端持久化订阅
        TopicSubscriber consumer = session.createDurableSubscriber(topic, "client-1");
        //指定消息监听器
        consumer.setMessageListener(new MessageListener() {
            //当监听的topic中存在消息,这个方法自动执行
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费者接收到消息:" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
        while (true) {

        }
    }
}
