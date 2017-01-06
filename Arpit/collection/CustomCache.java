package collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class CustomCache<K, V> {

	private long timeToLive;
	private Map<K, CacheObject> myCacheObjectMap = new ConcurrentHashMap<K, CacheObject>();

	class CacheObject<T> {
		public long lastAccessed = System.currentTimeMillis();
		public T value;

		protected CacheObject(T value) {
			this.value = value;
			
			class RunMeTask implements Runnable
			{
				@Override
				public void run() {
					System.out.println("\nCleanup performed");
					cleanup();
				}
			}
		}
	}

	public CustomCache(long timeToLive) {
		this.timeToLive = timeToLive * 1000;
	}

	public void put(K key, V value) {
		myCacheObjectMap.put(key, new CacheObject(value));
	}

	public <T> T get(K key) {
		CacheObject c = (CacheObject) myCacheObjectMap.get(key);
		if (c == null) {
			return null;
		} else {
			c.lastAccessed = System.currentTimeMillis();
			return (T) c.value;
		}
	}

	public void remove(K key) {
		myCacheObjectMap.remove(key);
	}

	private void cleanup() {
		long currentTime = System.currentTimeMillis();
		Iterator itr = myCacheObjectMap.keySet().iterator();

		while (itr.hasNext()) {
			String key = (String) itr.next();
			CacheObject c = myCacheObjectMap.get(key);
			
			if (c != null && (currentTime > (timeToLive + c.lastAccessed))) {
				myCacheObjectMap.remove(key);
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		CustomCache<String, String> myCustomCache = new CustomCache<>(1);
		myCustomCache.put("1", "A1");
		myCustomCache.put("2", "A2");
		myCustomCache.put("3", "A3");
		
		System.out.println(myCustomCache.get("1"));
		System.out.println(myCustomCache.get("2"));
		System.out.println(myCustomCache.get("3"));
		
		class RunMeTask extends TimerTask
		{
			@Override
			public void run() {
				System.out.println("\nCleanup performed");
				myCustomCache.cleanup();
			}
		}
		
		TimerTask task = new RunMeTask();

    	Timer timer = new Timer();
    	timer.schedule(task, 1000, 3000);
    	
    	Thread.sleep(5000);
    	
    	System.out.println(myCustomCache.get("1"));
		System.out.println(myCustomCache.get("2"));
		System.out.println(myCustomCache.get("3"));
	}
}
