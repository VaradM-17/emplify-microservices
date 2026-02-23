package com.varad.employeeservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.varad.employeeservice.dto.APIResponseDto;
import com.varad.employeeservice.dto.DepartmentDto;
import com.varad.employeeservice.dto.EmployeeDto;
import com.varad.employeeservice.entity.Employee;
import com.varad.employeeservice.exception.ResourceNotFoundException;
import com.varad.employeeservice.repository.EmployeeRepository;
import com.varad.employeeservice.service.APIClient;
import com.varad.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper;
	// private RestTemplate restTemplate;
	// private WebClient webClient;
	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

		String url = "http://localhost:8080/api/departments/" + employee.getDepartmentCode();

		// Using RestTemplate
		// ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(url,
		// DepartmentDto.class);
		// DepartmentDto departmentDto = responseEntity.getBody();

		// Using WebClient
		// DepartmentDto departmentDto =
		// webClient.get().uri(url).retrieve().bodyToMono(DepartmentDto.class).block();

		// Using Feign Client
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);

		return apiResponseDto;
	}

}
