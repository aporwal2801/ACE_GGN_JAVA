package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest {

	static class Fruit implements Comparable{
		String name;
		String flavour;

		public Fruit(String name, String flavour) {
			this.name = name;
			this.flavour = flavour;
		}
		
		@Override
		public int compareTo(Object o) {
			Fruit f = (Fruit)o;
			return this.name.compareTo(f.name);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Fruit> fruitList = new ArrayList<Fruit>();
		while (sc.hasNext()) {
			String s1 = sc.nextLine();
			Fruit f = new Fruit(s1, s1);
			fruitList.add(f);
		}
		
		Collections.sort(fruitList);
		
		for(Fruit f : fruitList){
			System.out.println(f.name);
		}
	}
}
