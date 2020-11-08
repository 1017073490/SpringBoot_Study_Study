package com.zhangxing.springbootweb.mapper;


import com.zhangxing.springbootweb.entities.Employee_cache;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmpCacheMapper {

    @Select("SELECT * FROM employee_cache WHERE id=#{id}")
    public Employee_cache getEmpById(Integer id);

    @Update("UPDATE employee_cache SET " +
            " lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId}" +
            " WHERE id=#{id}")
    public void updateEmp(Employee_cache employee_cache);

    @Delete("DELETE FROM employee_cache WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee_cache(lastName,email,gender,dId)" +
            " VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee_cache employee_cache);

    @Select("SELECT * FROM employee_cache WHERE lastName=#{lastName}")
    public Employee_cache getEmpByLastName(String lastName);
}
