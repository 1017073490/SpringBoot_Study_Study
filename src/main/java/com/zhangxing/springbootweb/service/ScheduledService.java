package com.zhangxing.springbootweb.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/7 19:37
 */
@Service
public class ScheduledService {

    //"0 * * * * MON-FRI"
    @Scheduled(cron = "0/5 * * * * 1-6")
    public void scheduleHello(){
        System.out.println("我出来了。。。");
    }
}
