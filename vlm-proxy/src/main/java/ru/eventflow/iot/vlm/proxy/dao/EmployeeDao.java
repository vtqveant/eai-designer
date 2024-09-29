package ru.eventflow.iot.vlm.proxy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

import java.util.List;

@Mapper
public interface EmployeeDao {
    Employee findEmployeeById(@Param("id") int id);

    List<Employee> findAllEmployees();
}
