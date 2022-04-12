package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    Optional<Employee> findEmployeeByAccount(String account);
}
