package com.zhangxing.springbootweb.controller;

import com.zhangxing.springbootweb.dao.DepartmentDao;
import com.zhangxing.springbootweb.dao.EmployeeDao;
import com.zhangxing.springbootweb.entities.Department;
import com.zhangxing.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/10/29 16:39
 */
@Controller
public class EmpController {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> daoAll = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", daoAll);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //自动封装
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps"; //需要测试
    }

    //来到修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model) {
        Employee employee = employeeDao.get(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
