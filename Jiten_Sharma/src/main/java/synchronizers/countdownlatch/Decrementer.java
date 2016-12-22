package synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/17/16
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Decrementer implements Runnable {
    CountDownLatch countDownLatch;

    public Decrementer(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;

    }
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
          this.countDownLatch.countDown();
            Thread.sleep(1000);
            this.countDownLatch.countDown();
        }   catch (InterruptedException e){

        }

    }
}
