package com.sapient.practice.collections;

public interface TimeBoundCache<K> {

	public Object getCacheObject(K key);
}
