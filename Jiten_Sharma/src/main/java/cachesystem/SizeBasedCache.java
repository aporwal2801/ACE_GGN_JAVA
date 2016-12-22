package cachesystem;

import cachesystem.notification.NotificationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by jsha22 on 11/16/2016.
 *
 * SizeBasedCache: here expiration time is not significant
 */
public class SizeBasedCache  implements Cache {

    private ConcurrentHashMap<String, CacheObject> cache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, String> cacheForLRU = new ConcurrentHashMap<>();
    BlockingQueue queue = new ArrayBlockingQueue(1000);
    private NotificationService notificationService = new NotificationService(queue);
    private long expirationTime=100;//default
    private final int DEFAULT_MAX_ENTRIES = 100;
    private int maxElements;


    public SizeBasedCache(int maxElements){
        if (maxElements <= 0) {
            throw new IllegalArgumentException("int maxElements parameter must be greater than 0");
        }
        this.maxElements=maxElements;
        startCleanupThread();
        new Thread(notificationService).start();
    }

    /**
     * Put a new object into cache. here -1 stands for no expiration
     *
     * if cache MAX_LIMIT is exhausted then we'll find least used element then delete it to provide entry for new one
     */
    public void put(String key, Object value) {
        if(cache.size() == maxElements){
            //remove oldest entry
            System.out.println("removing key, limit exhausted");
            List<Long> values = new ArrayList<>(cacheForLRU.keySet());
            Collections.sort(values, new Comparator<Long>() {
                public int compare(Long a, Long b) {
                    // no need to worry about nulls as we know a and b are both in pl
                    return b.compareTo(a);
                }
            });
            long firstValue = values.get(0);
            String firstKey = cacheForLRU.get(firstValue);
            System.out.println("removing oldest key, key:"+firstKey);
            CacheObject cacheObject = cache.remove(firstKey);
            queue.add(cacheObject);
        }
        CacheObject cacheObject = new CacheObject(value, expirationTime);
        cacheObject.setLastUseTime(System.currentTimeMillis());
        cache.put(key, cacheObject);
        cacheForLRU.put(cacheObject.getLastUseTime(), key);
    }

    /**
     * Get instance from cache, no need to be thread-safe.
     */
    public Object get(String key) {
        CacheObject cacheObject = cache.get(key);
        cacheObject.updateUseTime();
        cacheForLRU.put(cacheObject.getLastUseTime(), key);
        return cacheObject.getValue();
    }

    //using double check we are making sure no two thread are doing read and write operation at same time
    @Override
    public void cleanup() {
        for (String key : cache.keySet()) {
            System.out.println(cache.get(key)+"::"+cache.get(key).isExpired());
            CacheObject co = cache.get(key);
            if (co.isExpired()) {
                synchronized (co) {
                    if (co.isExpired()) {
                        cache.remove(key);
                        queue.add(co);
                    }
                }
            }
        }

    }

    /**
     * new cleanup thread will be created while construction, which will run at predefined interval to delete unused objects
     */
    private void startCleanupThread(){
        if (expirationTime > 0 ) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    try {
                        while (true) {

                            Thread.sleep(TimeUnit.MINUTES.toMillis(30));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    cleanup();
                }
            });
            t.setDaemon(true);
            t.start();
        }
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

}
