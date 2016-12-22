package otherexamples.orderredThread;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/12/16
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyThread implements Runnable{
    private SyncObj syncObj;
    private int count;

    public MyThread( SyncObj syncObj, int count){
        this.syncObj=syncObj;
        this.count=count;
    }

    @Override
    public void run() {

            while(syncObj.get() < count && syncObj.get() > count +1){
                synchronized (syncObj){
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }

        synchronized (syncObj){
            syncObj.inc();
            syncObj.print();
            syncObj.notifyAll();
        }

    }
}
