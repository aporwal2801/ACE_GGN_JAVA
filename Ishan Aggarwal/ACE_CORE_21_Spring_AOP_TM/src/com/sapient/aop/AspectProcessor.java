package com.sapient.aop;

public class AspectProcessor {

	static void preProcess() {
		System.out.println("Before invoking method");
	}

	static void postProcess() {
		System.out.println("After invoking method");
	}
}
