package com.sapient.ace.learning.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		Person person = (Person) applicationContext.getBean("person");
		Person person1 = (Person) applicationContext.getBean("person");
		System.out.println(person.getDepartment().hashCode()+"\t"+person1.getDepartment().hashCode());
		Department department = (Department) applicationContext.getBean("department");
		Department department1 = (Department) applicationContext.getBean("department");
		System.out.println(department.hashCode()+"\t"+department1.hashCode());
	}

}
