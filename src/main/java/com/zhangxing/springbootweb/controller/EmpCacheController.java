package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.entities.Employee_cache;
import com.zhangxing.springbootweb.service.EmployeeCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/5 18:21
 */
@RestController
public class EmpCacheController {

    @Autowired
    EmployeeCacheService employeeCacheService;

    @GetMapping("/empCache/{id}")
    public Employee_cache getEmp(@PathVariable("id") Integer id) {
        System.out.println(employeeCacheService.getEmp(id));
        return employeeCacheService.getEmp(id);
    }

    @GetMapping("/empCache")
    public Employee_cache updateEmp(Employee_cache employee_cache){
        System.out.println(employee_cache);
        return employeeCacheService.undapeEmp(employee_cache);
    }

    @GetMapping("/empCacheDelete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeCacheService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/empCacheByName/{string}")
    public Employee_cache getEmpByLastName(@PathVariable("string") String string) {
        return employeeCacheService.getEmpByLastName(string);
    }



}
