package cachesystem;

import cachesystem.notification.NotificationService;

import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by jsha22 on 11/16/2016.
 *
 * TimeBasedCache : an expiration time will be associated with each element which will be common for all and will be provided while construction.
 */
public class TimeBasedCache implements Cache {

    private ConcurrentHashMap<String, WeakReference<CacheObject>> cache = new ConcurrentHashMap<>();
    BlockingQueue queue = new ArrayBlockingQueue(1000);
    private NotificationService notificationService = new NotificationService(queue);
    private long expirationTime;
    public TimeBasedCache(long expirationTime){
        this.expirationTime=expirationTime;
        startCleanupThread();
        new Thread(notificationService).start();
    }

    /**
     * Put a new object into cache, and speicify its expiration time. Everytime we
     * get the object from cache, its expiration time would be updated.
     */
    public void put(String key, Object value) {
        CacheObject cacheObject = new CacheObject(value, expirationTime);
        WeakReference<CacheObject> weakReference = new WeakReference<CacheObject>(cacheObject);
        cache.put(key, weakReference);
    }

    /**
     * Get instance from cache, no need to be thread-safe.
     * Objects which have been expired will not be returned and will be deleted
     */
    public Object get(String key) {

        CacheObject cacheObject = cache.get(key).get();
        if (!cacheObject.isExpired()) {
            cacheObject.updateUseTime();
            return cacheObject.getValue();
        } else {
            cache.remove(key);
            queue.add(cacheObject);
            return null;
        }
    }

    //using double check we are making sure no two thread are doing read and write operation at same time
    @Override
    public void cleanup() {
        for (String key : cache.keySet()) {
            CacheObject co = cache.get(key).get();
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
