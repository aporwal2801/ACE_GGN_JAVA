package concurrentdatastructure.usingLockAndCondition;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/29/16
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyBlockingQueueUsingLockAndCondition<E> {

    private int size;
    private ArrayList<E> list;
    private Lock lock = new ReentrantLock(true);
    private Condition isFullCondition =  lock.newCondition();
    private Condition isEmptyCondition = lock.newCondition();

    public MyBlockingQueueUsingLockAndCondition(int size){
        list = new ArrayList<>(size);
        this.size = size;
    }

    public E read(){
        lock.lock();
        E e = null;
            try {
                while(list.size() == 0 ){
                    System.out.println("call isEmptyCondition.await()");
                    Thread.sleep(1000);
                    //isEmptyCondition.await();
                }
                e = list.get(0);//FIFO order
                list.remove(0);
                isFullCondition.signalAll();
            } catch (InterruptedException ie) {
                ie.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
                lock.unlock();
            }

        return e;
    }

    public void write(E e) {

        lock.lock();
        System.out.println(list.size()+"---"+size);
        try {
              while(list.size() == size){
                  System.out.println("call isFullCondition.await();");
                    isFullCondition.await();
                }
            list.add(e);
            isEmptyCondition.signalAll();
            } catch (InterruptedException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---");
        MyBlockingQueueUsingLockAndCondition<String> queue = new MyBlockingQueueUsingLockAndCondition(10);
        Producer reader = new Producer(queue);
        Consumer writer = new Consumer(queue);

        Thread writerThread = new Thread(reader);
        writerThread.start();

        Thread writerThread1 = new Thread(writer);
        writerThread1.start();

//        Thread writerThread2 = new Thread(writer);
//        writerThread2.start();
//
//        Thread readerThread = new Thread(reader);
//        readerThread.start();

        Thread.currentThread().join();
    }
}
