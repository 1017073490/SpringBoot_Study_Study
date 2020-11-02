package com.zhangxing.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/10/29 12:51
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam ("username") String username,
                        @RequestParam ("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "12345".equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else {
            //失败，
            map.put("msg","账密有误");
            return "login";
        }

    }
}
