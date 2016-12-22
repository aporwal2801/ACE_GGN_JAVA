package synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/17/16
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountDownL {
   public static void main(String[] args){
       CountDownLatch countDownLatch = new CountDownLatch(2);
       Waiter waiter = new Waiter(countDownLatch);
       Decrementer decrementer = new Decrementer(countDownLatch);
       new Thread(waiter).start();
       new Thread(decrementer).start();
   }

}
