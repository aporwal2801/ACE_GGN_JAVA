package multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/12/16
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>(10);

        Thread writerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i< 10000;i++){
                   synchronized (queue){

                       try {
                           System.out.println("adding");
                           queue.add(i);
                           notify();
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                       }
                   }
                }

            }
        });


        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (queue){

                        try {
                            while(queue.size() == 0){
                                wait();
                            }
                            System.out.println("removing");
                            queue.get(0);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                }


            }
        });
        readerThread.start();
        writerThread.start();
        //readerThread.interrupt();
    }
}
