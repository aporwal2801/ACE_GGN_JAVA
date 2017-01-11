package com.sapient.inject.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class StudentCollection {

	private Integer age;
	private String name;

	List<String> addressList;
	Set<String> addressSet;
	Map<Integer, String> addressMap;
	Properties addressProp;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public Map<Integer, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<Integer, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}

	@Override
	public String toString() {
		return "StudentCollection [age=" + age + ", name=" + name
				+ ", addressList=" + addressList + ", addressSet=" + addressSet
				+ ", addressMap=" + addressMap + ", addressProp=" + addressProp
				+ "]";
	}

}
