package com.sapient.application;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bean.Address;
import com.sapient.bean.Employee;

@SpringBootApplication
//@EnableAutoConfiguration
//@RestController
public class SpringBootRestApplication {

	private static Map<Integer, Employee> employeeMap = new ConcurrentHashMap<>();

	public static Map<Integer, Employee> getEmployees() {
		System.out.println("Inside getEmployees");
		return employeeMap;
	}

//	@RequestMapping("/")
//	String home() {
//		return "Hello World!";
//	}

	public static void main(String[] args) {

		 createEmployees();
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	private static void createEmployees() {
		System.out.println("Inside createEmployees");
		for (int i = 1; i <= 10; i++) {
			employeeMap.put(i, newEmployee(i));
		}
	}

	private static Employee newEmployee(int employeeId) {
		System.out.println("Inside newEmployee : " + employeeId);
		Employee emp = new Employee();
		Address address = new Address();
		emp.setEmployeeId(employeeId);
		emp.setEmployeeName("Ishan Aggarwal");
		address.setCityName("Gurgaon");
		address.setHouseNumber("1493");
		address.setStateName("Haryana");
		address.setStateName("Sector 15, Part - 2");
		emp.setEmployeeAddress(address);
		return emp;
	}

}
