package beanscope;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void displayInfo() { 
		System.out.println("\nName:"+name+" Age:"+age);
		
	}

}
