package com.sapient.aop;

import com.sapient.bean.Customer;

public class TestCustomerProcessor {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "David");
		CustomerService cs = (CustomerService) ProxyFactory.getProxy();
		cs.saveCustomer(customer);
	}
}
