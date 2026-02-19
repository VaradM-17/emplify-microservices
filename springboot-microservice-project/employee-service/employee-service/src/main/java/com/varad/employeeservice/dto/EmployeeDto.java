package com.varad.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Long id;

	@NotEmpty(message = "First name should not be empty")
	private String firstName;

	@NotEmpty(message = "Last name should not be empty")
	private String lastName;

	@NotEmpty(message = "Email should not be empty")
	private String email;
}
