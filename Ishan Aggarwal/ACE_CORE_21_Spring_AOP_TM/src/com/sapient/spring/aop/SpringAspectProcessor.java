package com.sapient.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.aop.CustomerService;

public class SpringAspectProcessor {
public static void main(String[] args) {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
//	CustomerService cs = ctx.getBean("customerService", CustomerService.class);
//	cs.getAllCustomer();
//	cs.saveCustomer(new Customer());
//	cs.getCustomerById(1);
//	
	CustomerAdditionalService aditonalDetail=ctx.getBean("additonalDetails",CustomerAdditionalService.class);
	aditonalDetail.getCustomerAdditionalDetails();
	((CustomerService)aditonalDetail).getCustomerById(5);
}
}
