package com.sapient.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestProducerConsumer {

	public TestProducerConsumer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BlockingQueue<Double> queue = new ArrayBlockingQueue<>(10);

		System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());
		ExecutorService consPool = Executors.newFixedThreadPool(4);
		ExecutorService prodPool = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 10; i++) {
			Producer prod = new Producer(queue);
			prodPool.submit(prod);
		}

		for (int i = 0; i < 10; i++) {
			Consumer cons = new Consumer(queue);
			consPool.submit(cons);
		}
		
		prodPool.shutdown();
		consPool.shutdown();
	}
}
