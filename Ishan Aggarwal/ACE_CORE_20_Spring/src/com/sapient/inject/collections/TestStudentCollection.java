package com.sapient.inject.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentCollection {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		StudentCollection studentCollection = context
				.getBean(StudentCollection.class);
		System.out.println(studentCollection.toString());
	}

}
