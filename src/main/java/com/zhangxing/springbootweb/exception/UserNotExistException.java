package com.zhangxing.springbootweb.exception;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/2 14:49
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
