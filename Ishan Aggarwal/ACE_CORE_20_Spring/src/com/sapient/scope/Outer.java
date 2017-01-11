package com.sapient.scope;

public class Outer {

	private Inner inner;

	private String outerString;
	private Integer outerInteger;

	public String getOuterString() {
		return outerString;
	}

	public void setOuterString(String outerString) {
		this.outerString = outerString;
	}

	public Integer getOuterInteger() {
		return outerInteger;
	}

	public void setOuterInteger(Integer outerInteger) {
		this.outerInteger = outerInteger;
	}

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}

	@Override
	public String toString() {
		return "Outer [inner=" + inner + ", OuterString=" + outerString
				+ ", OuterInteger=" + outerInteger + "]";
	}

}
