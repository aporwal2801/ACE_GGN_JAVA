package com.Generics;

import java.util.ArrayList;
import java.util.List;

public class Super_Extends_Test {

	
	public static void main(String[] args) {
		
		List <? extends Number> no = new ArrayList<>();
		
		no.add(3.14);
		no.add(3);
		no.add(null);
		
		List <? super Number> no1 = new ArrayList<>();
		no1.add(5, 2.14);
		no1.add(5, 2);
		no1.add(null);
	}
	}

