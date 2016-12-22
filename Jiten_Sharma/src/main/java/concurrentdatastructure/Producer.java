package concurrentdatastructure;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/28/16
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements Runnable {
    private MyBlockingQueueByList<String> queue;

    public Producer(MyBlockingQueueByList queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                for (int i=0; i < 100; i++){
                   String s = "no:"+i;
                   System.out.println("writer thread, "+s);
                   queue.write(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
