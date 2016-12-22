package synchronizers.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/18/16
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyThread implements Runnable {
    private Semaphore semaphore;
    private List<String> list;

    public MyThread(Semaphore semaphore, List list){
        this.semaphore=semaphore;
        this.list=list;
    }
    @Override
    public void run() {
        System.out.println("I am running"+Thread.currentThread().getId());
        try {
            int i=0;
            while(true){
                semaphore.acquire();
                System.out.println("adding objects into list "+Thread.currentThread().getId());
                list.add(i+"Thread;"+Thread.currentThread().getId());
                semaphore.release();
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
