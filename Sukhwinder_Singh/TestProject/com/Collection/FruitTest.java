package com.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Fruit> fruits = new ArrayList<>();
		
		fruits.add(new Fruit("apple"));
		fruits.add(new Fruit("mango"));
		fruits.add(new Fruit("banana"));
		fruits.add(new Fruit("graps"));
		
		Collections.sort(fruits);
		
		for (Fruit string : fruits) {
			System.out.println(string.getName());
		}
	}

}


class Fruit implements Comparable<Fruit> {
	
	String name;
	
	public Fruit(String s) {
			this.name=s;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Fruit o) {
		return this.name.compareTo(o.getName());
	}
}
