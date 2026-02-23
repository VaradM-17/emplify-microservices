package com.varad.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varad.employeeservice.dto.DepartmentDto;

@FeignClient(name = "department-service", url = "http://localhost:8080")
public interface APIClient {

	@GetMapping("/api/departments/{department-code}")
	DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);

}
