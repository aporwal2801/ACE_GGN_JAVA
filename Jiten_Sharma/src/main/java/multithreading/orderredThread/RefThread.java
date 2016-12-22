package multithreading.orderredThread;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/12/16
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RefThread implements Runnable{

    private SyncObj syncObj;
    private Thread parentThread;

    public RefThread(SyncObj syncObj, Thread parentThread){
        this.syncObj = syncObj;
        this.parentThread = parentThread;
    }

    @Override
    public void run() {

        if(parentThread != null){
            while(!parentThread.isAlive()){
                System.out.println("parent is still alive, "+Thread.currentThread().getName()+", "+parentThread.getName());
                try {
                    parentThread.join();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        syncObj.inc();
        syncObj.print();
    }
}
