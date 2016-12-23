package com.Cloning;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DeepCloning_Reflection {

	static void cloneObj(Object obj) throws SecurityException, ClassNotFoundException{
		
		Class<?> conClass = obj.getClass();
		
//		Field[] cls = Class.forName("com.Cloning.A").getDeclaredFields();
		Field[] cls = conClass.getDeclaredFields();
		//loop the fields -- chk for objects 
		//if obj then call deepcopy with that obj
	
		for (Field field : cls) {
		
			if(!field.getType().isPrimitive()){
				System.out.println("Fields " +field.getType().isPrimitive());
				cloneObj(field.getType());
			}
			
		}
		

		}

	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		A a = new A();
		
//		DeepCloning_Reflection.cloneObj(a);
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(1);
		l2.add(3);
		l2.add(2);
		System.out.println(l2.containsAll(l1));
		
		
	}
	
}

class A  implements Cloneable{
	int  a = 10 ; 
	B b = new B();
}


class B {
	
	 int b = 2;
	C  c = new C();
}

class C {
	
	int c = 5; 
}