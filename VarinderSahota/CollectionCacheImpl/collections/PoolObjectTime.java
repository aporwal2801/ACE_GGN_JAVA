package com.sapient.practice.collections;

import java.util.Iterator;

public class PoolObjectTime<K, V> implements Runnable {

	CacheImplementation cacheImplObject = null;

	PoolObjectTime(CacheImplementation cacheImplObj) {
		cacheImplObject = cacheImplObj;
	}

	@Override
	public void run() {
		while (cacheImplObject.getMap().size() > 0) {

			System.out
					.println("Pooling Cache for Timer Expiration Current Cache Size..."
							+ cacheImplObject.getMap().size());

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Iterator<K> itr = cacheImplObject.getMap().keySet().iterator();

			while (itr.hasNext()) {

				K k = itr.next();
				CacheObject cacheObject = (CacheObject) cacheImplObject
						.getMap().get(k);
				if (!cacheObject.poolTimerExpired()) {
					System.out.println("Thread " + cacheObject.printObject()
							+ " is Alive : " + cacheObject.poolTimerExpired());
					cacheImplObject.getMap().remove(k);
				} else {
					System.out.println("Thread " + cacheObject.printObject()
							+ " is Alive : " + cacheObject.poolTimerExpired());
				}
			}
			
			//Object obj = cacheImplObject.getCacheObject("2");
			//System.out.println("Object Accessed = " + obj.toString());
			
			System.out
					.println("Pooling Cache for Timer Expiration Current Cache Size..."
							+ cacheImplObject.getMap().size());

		}
	}
}
