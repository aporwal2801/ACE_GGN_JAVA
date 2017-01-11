package com.sapient.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sapient.model.Equity;
import com.sapient.service.EquityService;

public class TestEquity {

	public static void main(String str[]) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		// Get service from context. (service's dependency (ProductDAO) is
		// autowired in ProductService)
		EquityService equityService = ctx.getBean(EquityService.class);

		// Do some data operation

		equityService.add(new Equity("Hello", "Secure", "Buy", 40));
		equityService.add(new Equity("Hello1", "Secure1", "Sell", 50));
		equityService.getEquityById(2);

		ctx.close();

	}
}
