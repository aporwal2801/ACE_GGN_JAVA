package com.sapient.spring.aop;

public class CustomerAdditonalServiceImpl implements CustomerAdditionalService{

	@Override
	public void getCustomerAdditionalDetails() {
		System.out.println("providing additonal details");		
	}

}
