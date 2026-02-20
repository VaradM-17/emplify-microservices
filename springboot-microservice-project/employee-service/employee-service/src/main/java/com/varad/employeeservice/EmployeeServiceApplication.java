package com.varad.employeeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		logger.info("Employee Service Application started.");
	}

}
