package synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/17/16
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Waiter implements Runnable {

    CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
              try{
                  countDownLatch.await();
              }catch (InterruptedException e){

              }
          System.out.println("waiter released");
    }

}
