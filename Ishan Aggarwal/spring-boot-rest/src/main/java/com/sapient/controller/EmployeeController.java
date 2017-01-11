package com.sapient.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.application.SpringBootRestApplication;
import com.sapient.bean.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public String getEmployeeDetails(@PathVariable Integer id) {
		Map<Integer, Employee> employees = SpringBootRestApplication.getEmployees();
		Employee employee = employees.get(id);
		if (employee != null) {
			return employee.toString();
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Employee> getAllEmployees() {
		Map<Integer, Employee> employees = SpringBootRestApplication.getEmployees();
		Collection<Employee> values = employees.values();
		return values;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		Map<Integer, Employee> employees = SpringBootRestApplication.getEmployees();
		employees.put(employee.getEmployeeId(), employee);
		return employee;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable Integer id) {
		Map<Integer, Employee> employees = SpringBootRestApplication.getEmployees();
		employees.remove(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Employee update(@PathVariable Integer id, @RequestBody Employee contact) {
		Map<Integer, Employee> employees = SpringBootRestApplication.getEmployees();
		Employee update = employees.get(id);
		update.setEmployeeName("Vaibhav Jain");
		employees.put(id, update);
		return update;
	}

}
