package com.sapient.spring.di.required;

import org.springframework.beans.factory.annotation.Required;

public class Student {

	private Integer age;
	private String name;

	public Integer getAge() {
		return age;
	}

	@Required
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

}
