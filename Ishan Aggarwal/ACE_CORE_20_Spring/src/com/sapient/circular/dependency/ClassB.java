package com.sapient.circular.dependency;

public class ClassB {

	private ClassA a;

	public ClassB(ClassA aObj) {
		this.a = aObj;
	}

	@Override
	public String toString() {
		return "ClassB [a=" + a + "]";
	}

}
