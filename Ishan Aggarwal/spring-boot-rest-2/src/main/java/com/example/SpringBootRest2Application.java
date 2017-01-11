package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class SpringBootRest2Application {

	public static void main(String[] args) {
		callEmployeeService();
		SpringApplication.run(SpringBootRest2Application.class, args);
	}

	@RequestMapping(value = "/people-portal")
	private static Employee callEmployeeService() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject("http://localhost:8081/employees/01", Employee.class);
		System.out.println(employee.toString());
		return employee;
	}
}
