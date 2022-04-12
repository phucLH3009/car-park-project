package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees(int pageNumber, int pageSize);
    Employee getEmployeeById(long id);
}
