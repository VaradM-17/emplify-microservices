package com.varad.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DepartmentServiceApplication {

	private final static Logger logger = LoggerFactory.getLogger(DepartmentServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		logger.info("Department Service Application Started");
	}

}
