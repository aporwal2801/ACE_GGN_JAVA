package com.sapient.circular.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCircular {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		ClassA classA = context.getBean(ClassA.class);
		ClassB classB = context.getBean(ClassB.class);

		System.out.println("============================");
		
		System.out.println(classA.toString());
		System.out.println(classB.toString());

	}

}
