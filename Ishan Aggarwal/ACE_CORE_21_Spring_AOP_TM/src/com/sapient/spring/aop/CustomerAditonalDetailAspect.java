package com.sapient.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.sapient.aop.CustomerService;
import com.sapient.aop.CustomerServiceImpl;

@Component
@Aspect
public class CustomerAditonalDetailAspect {

	@DeclareParents(value="com.sape.practise.aop.spring.CustomerAdditionalService+",
			defaultImpl=CustomerServiceImpl.class)
	public static CustomerService customerService;
}
