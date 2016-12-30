package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/peopleportal")
public class PeoplePortalController
{
	@Value("${employee.resource.url}")
	private String employeeResourceUrl;
	
//	@Value("${add.employee.url}")
//	private String addEmployeeResourceUrl;

	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public List<Employee> employeeList()
	{
		RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        List<Employee> employees=rt.getForObject(employeeResourceUrl, List.class);
		return employees;
		
	}
	
	/*@RequestMapping("/addPeople")
	public void  addEmployee(@RequestBody Employee employee)
	{
		RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        rt.postForEntity(addEmployeeResourceUrl, employe);
		
	}*/
}
