package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhangxing
 * @Description: 测试
 * @date 2020/10/28 19:01
 */
@Controller
public class HelloController {

//    @RequestMapping({"/", "/login.html"})
//    public String index() {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String test(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "web";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        /*
         * 1.导入thymeleaf的名称空间
         * 2.使用语法
         * */
        map.put("A", "<h1>科技</h1>");
        map.put("B", "国家");
        map.put("L", Arrays.asList("zxTest", "zx2"));
        return "success";
    }
}
