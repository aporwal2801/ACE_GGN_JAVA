package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;


public class HelloWorld {

	String msg;
	
//	HelloB hb ; 
    
	@Autowired
	Address address ; 
	

//	public HelloWorld(HelloB b , String msg) {
//		this.hb=b;this.msg=msg;
//	}
//     public void setHb(HelloB hb) {
//		this.hb = hb;
//	}
	
	public Address getAddress() {
		return address;
	}
	
	
	@Required
	public void setMsg(String msg) {
		this.msg = msg;
		
	}public String getMsg() {
		return msg;
	}
	
	public void methodA() {
	System.out.println("Hello World Bean");
	}
}
