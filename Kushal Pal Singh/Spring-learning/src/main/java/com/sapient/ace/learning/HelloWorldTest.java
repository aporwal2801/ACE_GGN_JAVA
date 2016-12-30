package com.sapient.ace.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		//applicationContext.getAutowireCapableBeanFactory().createBean(String.class);
		System.out.println(helloWorld.getMsg() + "   " + helloWorld.getKey());
	}

}
