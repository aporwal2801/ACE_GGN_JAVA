package com.sapient.ace.learning.circulardependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		Person person = (Person) applicationContext.getBean("person");
		Department department = (Department) applicationContext.getBean("department");
	}

}
