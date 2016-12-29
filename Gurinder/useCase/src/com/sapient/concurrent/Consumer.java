package com.sapient.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Double> queue;

	public Consumer(BlockingQueue<Double> queue) {
		this.queue = queue;
	}

	public void consume() {
		try {
			System.out.println("Consumed : " + queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread Name - "+Thread.currentThread().getName());
		consume();
	}
}
