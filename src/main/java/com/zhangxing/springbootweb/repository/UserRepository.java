package com.zhangxing.springbootweb.repository;

import com.zhangxing.springbootweb.entities.JPA_User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/4 13:58
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<JPA_User, Integer> {

}
