package com.sapient.employee.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeSource {
	private static final Map<String, Employee> EMPLOYEES = new HashMap<>();
	static {
		Employee emp1 = new Employee();
		emp1.setId("01");
		emp1.setName("Joe");
		emp1.setAge(32);

		Employee emp2 = new Employee();
		emp2.setId("02");
		emp2.setName("Sam");
		emp2.setAge(41);

		Employee emp3 = new Employee();
		emp3.setId("03");
		emp3.setName("Phil");
		emp3.setAge(22);

		EMPLOYEES.put(emp1.getId(), emp1);
		EMPLOYEES.put(emp2.getId(), emp2);
		EMPLOYEES.put(emp3.getId(), emp3);
	}

	public static Collection<Employee> getEmployees() {
		return EMPLOYEES.values();
	}

	public static Optional<Employee> getEmployee(String empId) {

		Optional<Employee> employeeOptional = EMPLOYEES.entrySet().stream()
				.filter(map -> empId.equals(map.getKey()))
				.map(map -> map.getValue())
				.findFirst();

		return employeeOptional;
	}

	public static Map<String, Employee> getEmployeesMap() {
		return EMPLOYEES;
	}

}