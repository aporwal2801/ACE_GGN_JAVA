package com.DesignPattern.Factory;

import java.util.EnumSet;

public class FatcoryTest {

	enum colour {A,B};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this of method use factory pattern to return an New enumset with given element
		EnumSet<colour> a = EnumSet.of(colour.A);

	}

}
