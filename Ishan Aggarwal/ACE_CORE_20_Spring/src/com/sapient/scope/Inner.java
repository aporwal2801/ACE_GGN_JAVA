package com.sapient.scope;

public class Inner {

	private String innerString;
	private Integer innerInteger;

	public String getInnerString() {
		return innerString;
	}

	public void setInnerString(String innerString) {
		this.innerString = innerString;
	}

	public Integer getInnerInteger() {
		return innerInteger;
	}

	public void setInnerInteger(Integer innerInteger) {
		this.innerInteger = innerInteger;
	}

	@Override
	public String toString() {
		return "Inner [innerString=" + innerString + ", innerInteger="
				+ innerInteger + "]";
	}

}
