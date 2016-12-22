package concurrentdatastructure;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/28/16
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {

    private MyBlockingQueueByList<String> queue;
    public Consumer(MyBlockingQueueByList queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                String s = queue.read();
                System.out.println("reader thread, " + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
