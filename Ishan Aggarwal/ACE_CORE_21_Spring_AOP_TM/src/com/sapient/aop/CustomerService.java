package com.sapient.aop;

import java.util.List;

import com.sapient.bean.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int customerId);

	public List<Customer> getAllCustomer();
}
