package com.hello;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloB {

	String msg2;

	HelloWorld helloWorld;

	/*public HelloB(HelloWorld hw, String msg) {
		this.helloWorld = hw;
		this.msg2 = msg;
	}*/

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}

	public String getMsg2() {
		return msg2;
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

}
