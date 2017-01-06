package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Number> list1 = new ArrayList<Integer>();
		
		List<? super Number> list2 = new ArrayList<>();
		list2.add(1.2);
		
//		List<? extends Number> list3 = new ArrayList<Integer>();
//		list3.add((Object)1);
	}

}
