package otherexamples.orderredThread;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/12/16
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SyncObj{
    private int i;

    public synchronized void inc(){
        i++;
    }
    public synchronized void dec(){
        i--;
    }
    public synchronized void print(){
        System.out.println(i);
    }

    public int get(){
        return i;
    }
}
