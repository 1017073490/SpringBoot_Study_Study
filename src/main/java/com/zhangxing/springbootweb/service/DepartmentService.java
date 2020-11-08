package com.zhangxing.springbootweb.service;

import com.zhangxing.springbootweb.entities.Department;
import com.zhangxing.springbootweb.mapper.DepartmentMapper;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/6 14:54
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        Department department = departmentMapper.getDeptById(id);
        System.out.println(department);
        return department;
    }


}
