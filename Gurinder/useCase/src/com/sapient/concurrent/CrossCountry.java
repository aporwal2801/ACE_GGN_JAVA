package com.sapient.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CrossCountry {

    //initializing barrier with 3 threads, once threads will be
    //at the barrier they will be released.
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new Start());


    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            new Thread(new Runner(i)).start();
            Thread.sleep(600);
        }
    }

    //Default action that will be performed when all threads are at the barrier
    public static class Start implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 3; i > 0; i--) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
                System.out.println("Go!!! ");
            } catch (InterruptedException e) {
            }
        }
    }

    //Threads that will be reaching the barrier
    public static class Runner implements Runnable {
        private int runnerNumber;

        public Runner(int runnerNumber) {
            this.runnerNumber = runnerNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Runner " + runnerNumber + " is at the start position");
                //calling await() method which will makes thread to wait until
                //all collected at the barrie
                BARRIER.await();
                System.out.println("Runner " + runnerNumber + " is on the distance");
            } catch (Exception e) {
            }
        }
    }
}