package com.sapient.circular.dependency.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCicularSolution {

	public static void main(String s[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		ClassC classC = context.getBean(ClassC.class);
		ClassD classD = context.getBean(ClassD.class);
		System.out.println("===================");
		System.out.println(classC.toString());
		System.out.println(classD.toString());
	}
}
