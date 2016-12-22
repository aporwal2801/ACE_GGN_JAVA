package cachesystem.notification;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jsha22 on 11/17/2016.
 *
 * This is a Notification service which will receive notifications whenever any elements will be deleted from cache.
 */
public class NotificationService implements Runnable{
    private BlockingQueue queue = null;
    public NotificationService(BlockingQueue queue){
        this.queue = queue;
    }

    public void run() {
        try {
            //send notification here
            while(true){
                System.out.println(queue.take());
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
