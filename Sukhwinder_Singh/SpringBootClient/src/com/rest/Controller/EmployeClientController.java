package com.rest.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/call")
public class EmployeClientController {

	@RequestMapping(method= RequestMethod.GET)
	public String getEmp() {
		final String uri = "http://localhost:8080/emp";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
		
		return "EmpClient called";
	}
	@RequestMapping(method= RequestMethod.POST)
	public String saveEmp() {
		return "EmpClient saved";
	}
	
}
