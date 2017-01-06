package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {

	private String name;
	private Integer age;
	@Autowired
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void displayInfo(){  
	    System.out.println("Name:"+name + "Age =" + age + "Address" + address.getAddress() + address.getCity());  
	}

	public Integer getAge() {
		return age;
	}

	@Required
	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	} 
}
