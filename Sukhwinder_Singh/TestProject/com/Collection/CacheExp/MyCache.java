package com.Collection.CacheExp;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache {

	int retainTime = 0;
	Map<String,CacheObject> map = new ConcurrentHashMap<>();
	
	public MyCache(int time) {
		this.retainTime=time;
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
					try {
						Thread.sleep(1000);
						refreshCache();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		});
		t.start();
		
	}
	
	public void put(String k, String v){
		 	 map.put(k,new CacheObject(LocalTime.now(), v));
		 	 System.out.println();
	 }
	 
	public Object get(String k){
		 CacheObject cObj = map.get(k);
		 //use same obje,  return null if objt expire..
		 map.put(k,new CacheObject(LocalTime.now(), cObj.getValObject()));
		 return cObj.getValObject();
		 
	 }
	
	 void refreshCache(){
		 Set<String> s= map.keySet();
		 for (String string : s)
		 {
			LocalTime objTime = map.get(string).getTime();
//			if(objTime.equals(LocalTime.now().minusMinutes(retainTime))){
			if(LocalTime.now().isAfter(objTime.plusMinutes(retainTime))){
				System.out.println("Removing "+string);
				map.remove(string);
			}
		 }
		 
	 }

	
}

