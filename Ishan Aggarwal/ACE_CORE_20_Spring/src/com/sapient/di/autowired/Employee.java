package com.sapient.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

	private String name;
	private String age;

	@Autowired
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}

}
