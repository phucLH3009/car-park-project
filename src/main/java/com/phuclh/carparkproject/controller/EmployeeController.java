package com.phuclh.carparkproject.controller;

import com.phuclh.carparkproject.dto.request.EmployeeRequestDTO;
import com.phuclh.carparkproject.dto.response.EmployeeResponseDTO;
import com.phuclh.carparkproject.entity.Employee;
import com.phuclh.carparkproject.service.impl.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addEmployee(@RequestBody @Valid EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllEmployees(@RequestParam int pageNumber, @RequestParam(defaultValue = "3") int pageSize) {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees(pageNumber, pageSize).stream().map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class)).collect(Collectors.toList());
        if (employees.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(employeeService.getEmployeeById(id), EmployeeResponseDTO.class), HttpStatus.OK);
    }
}
