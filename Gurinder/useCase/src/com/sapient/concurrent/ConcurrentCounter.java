package com.sapient.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentCounter {

	private Object lock = new Object();
	private int index = 0;
	private List<Thread> tList = new ArrayList<Thread>();

	private int value = 1;
	private int MAX_LIMIT = 10;

	ConcurrentCounter(int maxLimit) {
		MAX_LIMIT = maxLimit;
	}

	/**
	 * 
	 */
	private Runnable task = new Runnable() {
		@Override
		public void run() {
			while (value <= MAX_LIMIT) {
				synchronized (lock) {
					try {
						while (value <= MAX_LIMIT && !Thread.currentThread().equals(getThread(index))) {
							lock.wait();
						}
						if (value > MAX_LIMIT)
							break;
					} catch (Exception e) {
						e.printStackTrace();
					}

					int v = getNextValue();
					System.out.println(Thread.currentThread().getName() + " <-> " + v);

					index = index + 1;
					lock.notifyAll();
				}
			}
		}
	};

	/**
	 * 
	 * @return
	 */
	private int getNextValue() {
		return value++;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	private Thread getThread(int index) {
		return tList.get(index % tList.size());
	}

	/**
	 * 
	 */
	private void start() {
		for (Thread t : tList) {
			t.start();
		}
	}

	/**
	 * 
	 * @param threadCount
	 * @param task
	 */
	private void addThread(int threadCount, Runnable task) {

		for (int i = 1; i <= threadCount; i++) {
			Thread t = new Thread(task);
			tList.add(t);
		}
	}

	private void await() throws InterruptedException {
		for (Thread t : tList) {
			t.join();
		}
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ConcurrentCounter alternator = new ConcurrentCounter(30);
		alternator.addThread(4, alternator.task);
		alternator.start();
		alternator.await();
		System.out.println("\nProgram terminated !!");
	}
}