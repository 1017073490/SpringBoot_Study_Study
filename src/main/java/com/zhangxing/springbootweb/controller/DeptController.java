package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.entities.*;
import com.zhangxing.springbootweb.entities.Employee;
import com.zhangxing.springbootweb.mapper.DepartmentMapper;
import com.zhangxing.springbootweb.mapper.EmployeeMapper;
import com.zhangxing.springbootweb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/4 9:16
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/deptCache/{id}")
    public Department getDeptCache(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }








    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/empMybatis/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/empMybatis")
    public Employee insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }

    @GetMapping("/empMybatisTest/{id}")
    public int getEmpId(@PathVariable("id") Integer id) {
        return id;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

}
