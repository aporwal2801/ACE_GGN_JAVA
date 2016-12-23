package com.Collection.CacheExp;

import java.time.LocalTime;


public class CacheObject {
	
	LocalTime time  = null;
	Object  valObject = null;
	
	public CacheObject(LocalTime t , Object o) {
	 this.time =t;
	 this.valObject =o;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}public LocalTime getTime() {
		return time;
	}public void setValObject(Object valObject) {
		this.valObject = valObject;
	}public Object getValObject() {
		return valObject;
	}
	

}
