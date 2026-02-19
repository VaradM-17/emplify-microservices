package com.varad.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.varad.employeeservice.dto.EmployeeDto;
import com.varad.employeeservice.entity.Employee;
import com.varad.employeeservice.exception.ResourceNotFoundException;
import com.varad.employeeservice.repository.EmployeeRepository;
import com.varad.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

		return modelMapper.map(employee, EmployeeDto.class);
	}

}
