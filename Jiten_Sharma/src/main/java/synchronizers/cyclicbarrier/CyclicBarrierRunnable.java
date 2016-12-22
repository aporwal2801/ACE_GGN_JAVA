package synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/17/16
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CyclicBarrierRunnable implements Runnable {

    private CyclicBarrier barrier1;
    private CyclicBarrier barrier2;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2){
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }
    @Override
    public void run() {

        try {
            System.out.println("waiting at barrier1");
            barrier1.await();

            Thread.sleep(100);
            System.out.println("waiting at barrier1");
            barrier2.await();
            System.out.println("DONE !!!");


        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch(BrokenBarrierException be){
             be.printStackTrace();
        }
    }
}
