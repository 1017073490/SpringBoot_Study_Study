package com.zhangxing.springbootweb.entities;

import javax.persistence.*;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/4 13:52
 */
//JPA：配置映射关系

@Entity //告诉JPA这是实体类
@Table(name = "tb1_user")   //@Table指定和哪个数据表对应
public class JPA_User {

    @Id //这是主键
    @GeneratedValue
    private Integer id;

    @Column
    private String lastName;

    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
