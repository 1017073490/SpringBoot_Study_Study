package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/7 19:29
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/asyncHello")
    public String asyncHello(){
        asyncService.hello();
        return "success";
    }
}
