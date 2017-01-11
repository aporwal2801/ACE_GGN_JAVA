package com.sapient.circular.dependency.solution;

public class ClassD {

	private ClassC classC;

	public ClassC getClassC() {
		return classC;
	}

	public void setClassC(ClassC classC) {
		this.classC = classC;
	}

	@Override
	public String toString() {
		return "ClassD [classC=]";
	}

}
