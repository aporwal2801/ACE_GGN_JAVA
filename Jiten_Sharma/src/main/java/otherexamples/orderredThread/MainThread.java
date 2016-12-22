package otherexamples.orderredThread;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/12/16
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainThread {
    public static void main(String[] args) {

        SyncObj syncObj = new SyncObj();
//        MyThread t1 = new MyThread(syncObj,0);
//        MyThread t2 = new MyThread(syncObj,1);
//        MyThread t3 = new MyThread(syncObj,2);
//        MyThread t4 = new MyThread(syncObj,3);

        Thread t1= new Thread(new RefThread(syncObj, null));
        Thread t2= new Thread(new RefThread(syncObj, t1));
        Thread t3= new Thread(new RefThread(syncObj, t2));
        Thread t4= new Thread(new RefThread(syncObj, t3));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
