package com.varad.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varad.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
