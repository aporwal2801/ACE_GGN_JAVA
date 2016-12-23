package com.sapient.practice.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sapient.practice.serialization.Employee;

public class CacheImplementation<K, V> implements TimeBoundCache<K> {

	private static int noOfObjects;
	private static int timeTolive;
	private Map concurrentMap = null;
	private Integer elementKey = new Integer(0);

	public CacheImplementation(int noObjects, int time) {
		noOfObjects = noObjects;
		timeTolive = time;
		concurrentMap = new ConcurrentHashMap<K, V>(noOfObjects);
	}

	public Map getMap() {
		return concurrentMap;
	}

	public String getUniqueId() {
		elementKey++;
		return elementKey.toString();
	}
	
	@Override
	public Object getCacheObject(K key) {

		CacheObject cacheObject = (CacheObject) this.concurrentMap.get(key);
		String tempValue = getUniqueId();
		Thread timerDelay = new Thread(new TimerDelay(timeTolive), tempValue
				+ "Thread : " + tempValue + " : "
				+ cacheObject.getObject().toString());

		CacheObject accessedObject = new CacheObject(cacheObject.getObject(),
				timeTolive, timerDelay);

		this.concurrentMap.replace(key, cacheObject, accessedObject);
		return cacheObject.getObject();
	}

	public static void main(String[] args) {

		CacheImplementation cacheImplementation = new CacheImplementation(10,
				10000);

		Employee e1 = new Employee("Varinder", "Sahota", 29);
		Employee e2 = new Employee("Ishan", "Aggarwal", 30);
		Employee e3 = new Employee("Rajat", "Gupta", 27);

		String tempVal1 = cacheImplementation.getUniqueId();
		String tempVal2 = cacheImplementation.getUniqueId();
		String tempVal3 = cacheImplementation.getUniqueId();

		Thread timerDelay1 = new Thread(new TimerDelay(timeTolive), "Thread : "
				+ tempVal1 + " : " + e1.toString());
		Thread timerDelay2 = new Thread(new TimerDelay(timeTolive), "Thread : "
				+ tempVal2 + " : " + e2.toString());
		Thread timerDelay3 = new Thread(new TimerDelay(timeTolive), "Thread : "
				+ tempVal3 + " : " + e3.toString());

		CacheObject c1 = new CacheObject(e1, timeTolive, timerDelay1);
		CacheObject c2 = new CacheObject(e2, timeTolive, timerDelay2);
		CacheObject c3 = new CacheObject(e3, timeTolive, timerDelay3);

		cacheImplementation.concurrentMap.put(tempVal1, c1);
		cacheImplementation.concurrentMap.put(tempVal2, c2);
		cacheImplementation.concurrentMap.put(tempVal3, c3);

		System.out.println("Main Thread Array Size = "
				+ cacheImplementation.concurrentMap.size());

		Thread evictionThread = new Thread(new PoolObjectTime(
				cacheImplementation));
		evictionThread.start();
		
		Object obj = cacheImplementation.getCacheObject(tempVal1);
		System.out.println("Object Accessed = " + obj.toString());
		
	}

}
