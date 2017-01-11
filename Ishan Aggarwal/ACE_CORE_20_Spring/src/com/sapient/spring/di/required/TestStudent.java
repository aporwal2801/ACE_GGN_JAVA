package com.sapient.spring.di.required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"Beans.xml");
		Student studentBean = applicationContext.getBean(Student.class);

		System.out.println(studentBean.toString());

	}

}
