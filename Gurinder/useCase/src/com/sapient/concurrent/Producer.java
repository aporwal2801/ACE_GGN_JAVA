package com.sapient.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Double> queue;

	public Producer(BlockingQueue<Double> queue) {
		this.queue = queue;
	}

	public void produce(Double value) {
		try {
			System.out.println("Produced : " + value);
			queue.put(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread Name - "+Thread.currentThread().getName());
		Double d = Math.random() * 100;
		produce(d);
	}
}
