package com.zhangxing.springbootweb.controller;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangxing.springbootweb.service.TicketService;
import org.springframework.stereotype.Component;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/8 15:29
 */
@Component
@Service
public class TicketController implements TicketService {
    @Override
    public String getTicket() {
        return "我和我的家乡";
    }
}
