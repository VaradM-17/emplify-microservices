package com.varad.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varad.employeeservice.dto.APIResponseDto;
import com.varad.employeeservice.dto.EmployeeDto;
import com.varad.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employees")
@AllArgsConstructor
@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id) {
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
}
