package com.sapient.employee.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.employee.exception.EmployeeNotPresentException;
import com.sapient.employee.model.Employee;
import com.sapient.employee.model.EmployeeSource;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public Collection getAllEmployees() {
		System.out.println("Successfully got all employees");
		return EmployeeSource.getEmployees();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable(value = "id") String id) {

		// this.validateUser(id);
		this.checkEmployeePresent(id);

		Collection<Employee> employees = EmployeeSource.getEmployees();
		Employee searchedEmployee = null;
		for (Employee emp : employees) {
			if (emp.getId().equals(id)) {
				searchedEmployee = emp;
				System.out.println("Successfully found employee with id : " + id);
				break;
			}
		}
		return searchedEmployee;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		Map<String, Employee> employeesMap = EmployeeSource.getEmployeesMap();
		employeesMap.put(employee.getId(), employee);
		System.out.println("Successfully created employee with id : " + employee.getId());
		System.out.println("Employee data : " + employee);
		return employee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {

		// this.validateUser(id);
		this.checkEmployeePresent(id);

		Map<String, Employee> employeesMap = EmployeeSource.getEmployeesMap();
		employeesMap.remove(id);
		System.out.println("Successfully delete employee with id : " + id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Employee update(@PathVariable(value = "id") String id, @RequestBody Employee contact) {

		// this.validateUser(id);
		this.checkEmployeePresent(id);

		Map<String, Employee> employeesMap = EmployeeSource.getEmployeesMap();
		Employee update = employeesMap.get(id);
		update.setAge(contact.getAge());
		update.setName(contact.getName());
		employeesMap.put(id, update);
		System.out.println("Successfully updated employee with id : " + id);
		System.out.println("Updated employee data : " + update);
		return update;
	}

	// private void validateUser(String employeeId) {
	// EmployeeSource.getEmployee(employeeId).orElseThrow(() -> new
	// EmployeeNotFoundException(employeeId));
	// }

	public String checkEmployeePresent(String employeeId) {
		Optional<Employee> employee = EmployeeSource.getEmployee(employeeId);
		if (!employee.isPresent()) {
			throw new EmployeeNotPresentException("Employee with id [" + employeeId + "] is not present.");
		}
		return "Employee Found";
	}

	@ExceptionHandler(value = EmployeeNotPresentException.class)
	public String employeeNotPresentExceptionHandler(EmployeeNotPresentException e) {
		return e.getMessage();
	}
}
