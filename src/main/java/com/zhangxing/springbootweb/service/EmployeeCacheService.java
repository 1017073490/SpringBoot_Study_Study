package com.zhangxing.springbootweb.service;

import com.zhangxing.springbootweb.entities.Employee_cache;
import com.zhangxing.springbootweb.mapper.EmpCacheMapper;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/5 18:15
 */
@CacheConfig(cacheNames = "empCache")
@Service
public class EmployeeCacheService {

    @Autowired
    EmpCacheMapper empCacheMapper;

    @Cacheable(
            //condition = "#a0>1",
            //key = "#root.methodName+'['+#id+']'")
            //keyGenerator = "myKeyGenerator",
            key = "#id",
            unless = "#id>999  ")
    public Employee_cache getEmp(Integer id) {
        System.out.println("查询" + id + "员工");
        Employee_cache emp = empCacheMapper.getEmpById(id);
        return emp;
    }

    @CachePut(key = "#result.id")
    public Employee_cache undapeEmp(Employee_cache employee_cache) {
        System.out.println("更新了员工" + employee_cache.getId());
        empCacheMapper.updateEmp(employee_cache);
        return employee_cache;
    }

    @CacheEvict(allEntries = true)
    public void deleteEmp(Integer integer) {
        System.out.println("删除了" + integer + "员工");
        //empCacheMapper.deleteEmpById(integer);
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public Employee_cache getEmpByLastName(String lastName) {
        return empCacheMapper.getEmpByLastName(lastName);
    }

}
