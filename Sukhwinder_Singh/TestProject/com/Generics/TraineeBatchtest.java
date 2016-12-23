package com.Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraineeBatchtest {

	public static void main(String[] args) {
	
//		mapTest();
//		
//		genericTest();
		
//		genericMaxCollection();
		
		
	}


	private static void genericMaxCollection() {
		List<Integer> i = new ArrayList<>();
		i.add(2);
		i.add(5);
		i.add(7);
		int a = maxOfCollection(i, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
		});
		
		System.out.println(a);
	}


//	static Integer maxOfCollection(List<Integer> list , Comparator c ){
//		list.sort(c);
//		return list.get(0);
//	}
	
	static  Integer maxOfCollection(List<Integer> list , Comparator c ){
		list.sort(c);
		return list.get(0);
	}
	
////max from any collection list
//	 static <T> T  maxOfCollection( List<? extends Comparable> list) {
////		 list.max
//		 
//		return T;
//
//		
//	}



	private static void genericTest() {
		String a ="as";
		String b ="asd";
		List<String> l= returnList(a,b );
		for (String string : l) {
			System.out.println(string);
		}
		
		int a1 =1;
		int b1 =2;
		List<Object> l1= returnList(a1,b );
		for (Object string : l1) {
			System.out.println(string);
		}
	}
	
	

	private static void mapTest() {
		Map<Integer,List<String>> batchInfo = new HashMap<Integer,List<String>>();
		
		List <String> students = new ArrayList<>();
		students.add("A");
		students.add("B");
		List <String> students2 = new ArrayList<>();
		students2.add("C");
		students2.add("D");	
		
		batchInfo.put(1, students);
		batchInfo.put(2, students2);
		
		//print
		
		for (Integer string : batchInfo.keySet()) {
			System.out.println(  string+ " "+batchInfo.get(string));	
		}
	}

	static	<E>  List<E>  returnList(E... e){
		List<E> l= new ArrayList<E>();
		for (E e2 : e) {
			l.add(e2);
		}
		return l;	
	}
	
		
	}

	



