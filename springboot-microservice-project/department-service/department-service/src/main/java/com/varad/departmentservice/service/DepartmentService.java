package com.varad.departmentservice.service;

import com.varad.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String departmentCode);

}
