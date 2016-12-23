package com.Generics;

import java.util.ArrayList;
import java.util.List;

public class Eff_Test {

	
	
	// Uses raw type (List) - fails at runtime!
	public static void main(String[] args) {
	List<String> strings = new ArrayList<String>();
	unsafeAdd(strings, new Integer(42));
//	strings.add( new Integer(42), "sadd");
	String s = strings.get(0); // Compiler-generated cast
	}
	private static void unsafeAdd(List<Object> list, Object o) {
	list.add(o);
	}
}
