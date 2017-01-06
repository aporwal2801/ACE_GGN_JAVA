package generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class A implements Serializable, Cloneable{
	
}

class B implements Cloneable, Serializable{
	
}
public class GenericTest4 {

	public static void main(String args[]) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new ArrayList<String>();
		
		System.out.println(list1.equals(list2));
	
	}
}
