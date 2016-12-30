package com.sapient.ace.learning.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

	@Autowired
	private Department department;

	public Person() {
		super();
	}

	public Person(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
