package synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/17/16
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class CyclicExample {

    public static void main(String[] args){
        Runnable barrierAction1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("action 1 executed");
            }
        };

        Runnable barrierAction2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("action 2 executed");
            }
        };
        CyclicBarrier barrier1 = new CyclicBarrier(2, barrierAction1);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrierAction2);

        CyclicBarrierRunnable runnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable runnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
        System.out.println("CyclicExample.main");
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

}
