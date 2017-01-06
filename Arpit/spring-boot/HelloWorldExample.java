package springboot;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/hello/")
public class HelloWorldExample {

	Map<Integer, Employee> myMap = new HashMap<Integer, Employee>();
	
	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		return myMap.get(empId);
	}
    
    @RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		myMap.put(emp.getId(), emp);
		return emp;
	}
    @RequestMapping(value = "/rest/emp/update", method = RequestMethod.PUT)
	public @ResponseBody Employee updateEmployee(@RequestBody Employee emp) {
		myMap.put(emp.getId(), emp);
		return emp;
	}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldExample.class, args);
    }
    
    @RequestMapping("/rest/emp/ex1")  
    public String ex1(){  
        throw new NumberFormatException("Got Number format exception");  
    } 
    
    @ExceptionHandler(value = NumberFormatException.class)  
    public String nfeHandler(NumberFormatException e){  
        return e.getMessage();  
    } 

}