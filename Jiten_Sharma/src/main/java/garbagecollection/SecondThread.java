package garbagecollection;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/19/16
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class SecondThread implements Runnable {
    private SharedResource sharedResourceA;
    private SharedResource sharedResourceB;
    SecondThread(SharedResource sharedResourceA, SharedResource sharedResourceB){
        this.sharedResourceA = sharedResourceA;
        this.sharedResourceB = sharedResourceB;
    }
    @Override
    public void run() {
        synchronized (sharedResourceB){
            System.out.println("sharedResourceB locked by, "+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"trying to take lock on sharedResourceA");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            synchronized (sharedResourceA){
                System.out.println("sharedResourceA locked by, "+Thread.currentThread().getName());
            }
        }
    }
}
