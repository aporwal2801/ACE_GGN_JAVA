package com.sapient.di.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		Employee bean = context.getBean(Employee.class);
		System.out.println(bean.toString());
	}

}
