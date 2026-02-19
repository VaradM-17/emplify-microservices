package com.varad.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.varad.departmentservice.dto.DepartmentDto;
import com.varad.departmentservice.entity.Department;
import com.varad.departmentservice.exception.ResourceNotFoundException;
import com.varad.departmentservice.repository.DepartmentRepository;
import com.varad.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = modelMapper.map(departmentDto, Department.class);
		Department savedDepartment = departmentRepository.save(department);
		return modelMapper.map(savedDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with code: " + departmentCode));

		return modelMapper.map(department, DepartmentDto.class);
	}

}
