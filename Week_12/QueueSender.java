package com.example.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.print.attribute.standard.Destination;

public class QueueSender {
    private static final String url = "tcp://localhost:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2.创建连接
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.创建一个目标
        Queue destination = session.createQueue(queueName);

        //6.创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            producer.send(textMessage);
            System.out.println("发送消息：" + textMessage.getText());
        }

        //8.关闭连接
        connection.close();
    }
}
