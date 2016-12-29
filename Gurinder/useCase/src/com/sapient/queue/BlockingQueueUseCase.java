package com.sapient.queue;

import java.util.LinkedList;
import java.util.Queue;

class Consumer<E> {
	Queue<E> queue;
	int MAX_SIZE = 10;

	Consumer(Queue<E> queue) {
		this.queue = queue;
	}

	Consumer(Queue<E> queue, Integer size) {
		this.queue = queue;
		this.MAX_SIZE = size;
	}

	public void consume() {
		synchronized (queue) {
			if (queue.size() == 0)
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Item consumed is : " + queue.poll());
			queue.notify();
		}
	}
}

class Producer<E> {
	Queue<E> queue;
	int MAX_SIZE = 10;

	Producer(Queue<E> queue) {
		this.queue = queue;
	}

	Producer(Queue<E> queue, Integer size) {
		this.queue = queue;
		this.MAX_SIZE = size;
	}

	public void produce(E element) {
		synchronized (queue) {
			if (queue.size() == MAX_SIZE)
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Item produced is : " + element);
			queue.offer(element);
			queue.notify();
		}
	}
}

public class BlockingQueueUseCase {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Integer size = 3;
		Queue<Integer> queue = new LinkedList<Integer>();
		Producer producer = new Producer(queue, size);
		Consumer consumer = new Consumer(queue, size);

		Thread producerTh = new Thread(new Runnable() {
			public void run() {
				while (true) {
					Double value = Math.random() * 10;
					producer.produce(value);
				}
			}
		}, "Producer");

		Thread consumerTh = new Thread(new Runnable() {
			public void run() {
				while (true) {
					consumer.consume();
				}
			}
		}, "Consumer");

		producerTh.start();
		consumerTh.start();
	}
}
