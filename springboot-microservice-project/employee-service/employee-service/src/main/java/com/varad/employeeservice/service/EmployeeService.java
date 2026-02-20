package com.varad.employeeservice.service;

import com.varad.employeeservice.dto.APIResponseDto;
import com.varad.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long employeeId);
}
