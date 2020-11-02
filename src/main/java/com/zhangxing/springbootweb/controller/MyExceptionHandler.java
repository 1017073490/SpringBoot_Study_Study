package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxing
 * @Description: 异常处理器
 * @date 2020/11/2 14:57
 */
@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public String handleException(Exception e){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("code", "user.notExist");
//        map.put("message", e.getMessage());
//        return e.getMessage();
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e,
                                  HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        //传入我们自己的错误状态码.否则 不会进入自己的错误解析页面
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notExist");
        map.put("message", "用户数据有误啦！");
        request.setAttribute("ext", map);
        return "forward:/error";
}

}
