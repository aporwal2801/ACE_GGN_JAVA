package garbagecollection;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/19/16
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainProgram {
    public static void main(String[] args) {
        SharedResource sharedResourceA = new SharedResource(3, "Jiten");
        SharedResource sharedResourceB = new SharedResource(4, "Sharma");
        Thread t1 = new Thread(new FirstThread(sharedResourceA, sharedResourceB));
        Thread t2 = new Thread(new SecondThread(sharedResourceA, sharedResourceB));
        System.out.println("starting threads from main program");
        t1.start();
        t2.start();
        System.out.println("finished");
    }
}
