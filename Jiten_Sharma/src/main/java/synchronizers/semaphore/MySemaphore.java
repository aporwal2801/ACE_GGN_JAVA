package synchronizers.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/18/16
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 *
 * This is Semaphore implementation which is introduced in java.util.concurrent.Semaphore
 */
public class MySemaphore {
    private static Semaphore semaphore = new Semaphore(2);
    private static List<String> sharedList = new ArrayList<>();

    public static void main(String[] args) {
        //now create two threads which will acquire lock on this shared list and maintain synchronization.
        MyThread thread1 = new MyThread(semaphore, sharedList);
        MyThread thread2 = new MyThread(semaphore, sharedList);
        MyThread thread3 = new MyThread(semaphore, sharedList);

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();

        try {
            while (true){
                semaphore.acquire();
                System.out.println("main thread, size of list:"+sharedList.size());
                Thread.sleep(2000);
                semaphore.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
