package com.GC.DealLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDump_DeadLock {

	static Lock l1 = new ReentrantLock();
	static Lock l2 = new ReentrantLock();

	public static void main(String[] args) {

		Thread t1 = new Thread(new workerA());
		Thread t2 = new Thread(new workerB());
		t1.setName("MineT_1");t2.setName("MineT_2");
		t1.start();
		t2.start();

	}

	static class workerA implements Runnable {

		@Override
		public void run() {
			synchronized (l1) {
				System.out.println(" WorkerA Holding Lock 1");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" WorkerA Waiting for Lock 2");
				synchronized (l2) {
					System.out.println(" WorkerA Hold 1 an 2 ");
				}
			}
		}
	}

	static class workerB implements Runnable {

		@Override
		public void run() {
			synchronized (l2) {
				System.out.println(" WorkerB Holding Lock 2");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" WorkerB Waiting for Lock 1");
				synchronized (l1) {
					System.out.println(" WorkerB Hold 1 an 2 ");
				}
			}
		}
	}

}
