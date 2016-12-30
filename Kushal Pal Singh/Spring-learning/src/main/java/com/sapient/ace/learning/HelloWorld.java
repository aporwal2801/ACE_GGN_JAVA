package com.sapient.ace.learning;

import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {

	private String msg;
	private String msg2;
	private Integer key;

	public String getMsg() {
		return msg;
	}

	@Required
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg2() {
		return msg2;
	}
	@Required
	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
	
}
