package com.sapient.concurrent;

import java.util.concurrent.CountDownLatch;

class StudentCounter implements Runnable {

	private CountDownLatch latch;

	StudentCounter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Student : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		}
	}
}

public class MyCountdownLatch {

	public MyCountdownLatch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int count = 2;
		CountDownLatch latch = new CountDownLatch(count);
		StudentCounter counter = new StudentCounter(latch);
		Thread th = new Thread(counter);

		try {
			th.start();
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Main Thread Ended");
	}
}
