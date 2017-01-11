package com.sapient.employee.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sapient.employee.controller.EmployeeController;

@SpringBootApplication
@ComponentScan(basePackageClasses= EmployeeController.class)
public class SpringBootEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeApplication.class, args);
	}
}
