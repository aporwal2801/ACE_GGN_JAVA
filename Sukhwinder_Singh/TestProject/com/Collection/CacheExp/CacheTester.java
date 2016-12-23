package com.Collection.CacheExp;

public class CacheTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCache cac = new MyCache(1);
		
		cac.put("A", "ABC");
		cac.put("B", "BCD");
		
		cac.get("B");
	}

}
