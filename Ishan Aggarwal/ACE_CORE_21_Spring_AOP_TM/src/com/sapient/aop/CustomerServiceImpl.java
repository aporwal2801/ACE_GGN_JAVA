package com.sapient.aop;

import java.beans.Transient;
import java.util.List;

import com.sapient.bean.Customer;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public void saveCustomer(Customer customer) {
		System.out.println("Cutomer is being persisted");
	}

	@Override
	public Customer getCustomerById(int customerId) {
		System.out.println("Getting customer for id "+customerId);
		Customer cus=new Customer(customerId,"");
		return cus;
	}

	@Override
	@Transient
	public List<Customer> getAllCustomer() {
		System.out.println("All customer returned");
		return null;
	}

}
