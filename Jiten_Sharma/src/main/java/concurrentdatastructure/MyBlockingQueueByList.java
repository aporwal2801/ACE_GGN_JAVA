package concurrentdatastructure;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/28/16
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 *
 * point to remember while implementing Blocking Queue
 * size,
 * wait when reaches full size by writer
 * notify when item is available to reader by writer
 */
public class MyBlockingQueueByList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<E> list = new ArrayList<>();
    private int size;

    public MyBlockingQueueByList(int size){
        if(size < 1){
            throw new IllegalArgumentException("size can not less than 1");
        }
        this.size = size;
    }

    public synchronized E read() throws InterruptedException {
        while(list.size() == 0){    //prevent from spurious wake up
            System.out.println("no elements inside, you have to wait");
            wait();
        }
        E e= null;
        e = list.get(0);
        list.remove(0);
        notifyAll();
        return e;
    }

    public synchronized void write(E e) throws InterruptedException {
        while(list.size() == size){
            System.out.println("no room available, you have to wait till room available");
            wait();
        }
        list.add(e);
        notifyAll();
    }

}
