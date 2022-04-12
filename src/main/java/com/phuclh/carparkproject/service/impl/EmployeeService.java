package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.Employee;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.EmployeeRepository;
import com.phuclh.carparkproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        //validate account
        if (employeeRepository.findEmployeeByAccount(employee.getAccount()).isPresent()) {
            throw new ExistedException("Employee with this account " + employee.getAccount() + " existed!");
        }
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<Employee> getAllEmployees(int pageNumber, int pageSize) {
        return employeeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee with this id " + id + " not found"));
    }
}
