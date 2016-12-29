package com.sapient.pool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolTasks<E> extends Thread {

	private BlockingQueue<E> queue = null;
	private boolean flag = false;

	ThreadPoolTasks(BlockingQueue<E> queue) {
		this.queue = queue;
	}

	public void stopThread() {
		this.flag = true;
		this.interrupt();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Runnable task = null;
		while (!flag) {
			try {
				task = (Runnable) this.queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			task.run();
		}
	}
}
