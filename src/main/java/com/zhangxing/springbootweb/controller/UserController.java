package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.entities.JPA_User;
import com.zhangxing.springbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/4 14:03
 */

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public JPA_User getUser(@PathVariable("id") Integer id){
        JPA_User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public JPA_User insertUser(JPA_User jpaUser){
        JPA_User user = userRepository.save(jpaUser);
        return user;
    }
}
