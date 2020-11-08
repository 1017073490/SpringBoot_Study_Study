package com.zhangxing.springbootweb.mapper;

import com.zhangxing.springbootweb.entities.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
