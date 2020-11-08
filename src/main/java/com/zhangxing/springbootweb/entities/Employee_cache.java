package com.zhangxing.springbootweb.entities;

import java.io.Serializable;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/5 13:40
 */
public class Employee_cache implements Serializable {
    @Override
    public String toString() {
        return "Employee_cache{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dId=" + dId +
                '}';
    }

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
