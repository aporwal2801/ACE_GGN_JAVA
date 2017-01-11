package com.sapient.circular.dependency;

public class ClassA {

	private ClassB b;

	public ClassA(ClassB bObj) {
		this.b = bObj;
	}

	@Override
	public String toString() {
		return "ClassA [b=" + b + "]";
	}

}
