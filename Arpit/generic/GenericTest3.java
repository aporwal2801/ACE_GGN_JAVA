package generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GenericTest3 {

	public static void main(String args[]) {
		Map<Integer, List<String>> traineeMap = new HashMap<Integer, List<String>>();

		List<String> traineeList1 = new ArrayList<String>();
		traineeList1.add("trainee1");
		traineeList1.add("trainee2");
		traineeList1.add("trainee3");
		traineeList1.add("trainee4");

		List<String> traineeList2 = new ArrayList<String>();
		traineeList2.add("trainee5");
		traineeList2.add("trainee6");
		traineeList2.add("trainee7");
		traineeList2.add("trainee8");

		traineeMap.put(10012011, traineeList1);
		traineeMap.put(11012011, traineeList2);

		Iterator it = traineeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
//			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		List<Integer> intList = genericMethod(1, 2, 3);
//		System.out.println(intList);

		List<String> strList = genericMethod("1", "2", "3");
//		System.out.println(strList);
		
		List<Integer> intList2 = genericMethod(1, 2, 3, 7, 8,9);
		Integer max1 = maximum(intList2);
		System.out.println(max1);
		List<Double> doubleList1 = genericMethod(1.1, 2.2, 3.3, 7.7, 8.8,9.9);
		Double max2 = maximum(doubleList1);
		System.out.println(max2);
	
	}

	public static <T extends Comparable & Serializable> List<T> genericMethod(T... args) {
		List<T> list = new ArrayList<T>();

		for (T t : args) {
			list.add(t);
		}
		return list;
	}
	
	public static <T extends Comparable<T>> T maximum(Collection<T> collection){
		T max = collection.iterator().next();
		for (T t : collection)
		{
			if (max.compareTo(t) < 0){
				max = t;
			}
		}
		return max;
	}
}
