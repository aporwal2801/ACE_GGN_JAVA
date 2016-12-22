package javafundamentals;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/1/16
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentCounter {
    public static void main(String[] args) {

        //old techniques
//        Thread old1 = new Thread(new old());
//        Thread old2 = new Thread(new old());
//        old1.start();
//        old2.start();

        //using concurrent
//        Thread new1 = new Thread(new Concurrent());
//        Thread new2 = new Thread(new Concurrent());
//        new1.start();
//        new2.start();

        //using atomic reference
        Thread new3 = new Thread(new UsingAtomic());
        Thread new4 = new Thread(new UsingAtomic());
        new3.start();
        new4.start();

    }
}

class old implements Runnable{

    private static int counter;
    public synchronized void incrementCounter(){
        System.out.println("Thread:"+Thread.currentThread().getId());
        counter++;
    }

    @Override
    public void run() {
        while(counter < 1000){
            incrementCounter();
        }

    }
}

class Concurrent implements Runnable{
    private Lock lock = new ReentrantLock(true);

    private static int counter;
    public void incrementCounter(){
        lock.lock();
        System.out.println("Thread:"+Thread.currentThread().getId());
        counter++;
        lock.unlock();
    }

    @Override
    public void run() {
        while(counter < 1000){
            incrementCounter();
        }

    }
}

class UsingAtomic implements Runnable{
    private static AtomicInteger counter =  new AtomicInteger(1);  // by default it is zero

    public void incrementCounter(){
        System.out.println(counter.get()+"Thread:"+Thread.currentThread().getId());
        counter.getAndIncrement();

    }

    @Override
    public void run() {
        while(counter.get() < 1000){
            incrementCounter();
        }

    }
}
