package com.MultiThread.ThreadPool;

public class MyFixedThreadPool {

	public static void main(String[] args) {
		startThreadPool(5);
	}

	static void startThreadPool(int count) {

		for (int i = 0; i < count; i++) {
			Thread t = new Thread(new MyThreadPool());

			t.start();
			
		}
	}

}

class MyThreadPool implements Runnable {

	public MyThreadPool() {
		// TODO Auto-generated constructor stub
	}

	synchronized void checkTask() {

		System.out.println("Checking task Queue " + Thread.currentThread().getName());
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			checkTask();
		}
	}
}
