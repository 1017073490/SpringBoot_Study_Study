package com.zhangxing.springbootweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangxing.springbootweb.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/8 15:53
 */
@Service
public class ConsumerController {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到了：" + ticket);
    }
}
