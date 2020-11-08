package com.zhangxing.springbootweb.service;

import com.zhangxing.springbootweb.entities.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/7 10:29
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Object o) {
        System.out.println("收到消息：" + o);
    }

    @RabbitListener(queues = "atguigu")
    public void receive2(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}
