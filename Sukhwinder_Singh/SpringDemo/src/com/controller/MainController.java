package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.HelloWorld;

public class MainController {

	public static void main(String[] args) {

		HelloWorld hw = null;
		// BeanFactory context= new
		// XmlBeanFactory(newClassPathResource("com/config/Bean.xml"));

		ApplicationContext context = new ClassPathXmlApplicationContext("com/config/Bean.xml");

//  Singlton and Prototype		
//		hw = (HelloWorld) context.getBean("hw");
//		hw.setMsg("Custom Msg1");
//		System.out.println("First Obj " + hw.getMsg());
//
//		hw = (HelloWorld) context.getBean("hw");
//		// in protype case the msg will be different
//		System.out.println("Second Obj " + hw.getMsg());
		
		System.out.println(hw.getAddress().getAdd1());

	}

}
