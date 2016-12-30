package com.sapient.ace.learning.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;

public class Department {

	@Autowired
	private Person person;

	
	public Department() {
		super();
	}

	public Department(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
