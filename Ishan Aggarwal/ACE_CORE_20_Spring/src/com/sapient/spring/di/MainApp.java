package com.sapient.spring.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"Beans.xml"));
		HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
		helloWorld.printMessage();

		HelloWorld helloWorld1 = (HelloWorld) beanFactory.getBean("myHelloWorld");
		helloWorld1.printMessage();

	}

}
