package com.sapient.employee.exception;

public class EmployeeNotPresentException extends RuntimeException {
	public EmployeeNotPresentException(String string) {
		super(string);
	}
}
