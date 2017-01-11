package com.sapient.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object getProxy() {
		CustomerService customerService = new CustomerServiceImpl();
		InvocationHandler invocationHandler = new CustomInvocationHandler(
				customerService);
		CustomerService csProxy = (CustomerService) Proxy.newProxyInstance(
				TestCustomerProcessor.class.getClassLoader(),
				new Class<?>[] { CustomerService.class }, invocationHandler);
		 return csProxy;
//		return customerService;
	}
}
