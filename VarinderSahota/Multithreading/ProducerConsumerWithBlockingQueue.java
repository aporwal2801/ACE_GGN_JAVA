package com.sapient.practice.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithBlockingQueue<T> {
	
	private BlockingQueue<T> bq = null;
	
	public ProducerConsumerWithBlockingQueue(int capacity)
	{
		bq = new LinkedBlockingQueue<T>(capacity);
	}
	
	public void put(T object)
	{
		System.out.println(" Producer Putting object = "+object.toString());
		bq.add(object);
		System.out.println(" Producer BQ Size = "+bq.size());
	}
	
	public T get()
	{
		T result = null;
		
		try {
			result = (T) bq.take();
			System.out.println(" Consumer taking object = "+result.toString());
			System.out.println(" Consumer BQ Size = "+bq.size());
		} catch (InterruptedException e) {
		}
		return result; 
	}
	
	

	public static void main(String[] args) {
		System.out.println("Main Started");
		
		int cap = 5;
		
		ProducerConsumerWithBlockingQueue<Integer> prodConsBQ = new ProducerConsumerWithBlockingQueue(cap);
		
		
		Thread threadOne = new Thread(new Runnable() {
			int value = 11;
			int i = 0;
			@Override
			public void run() {

				while (i < cap) {
					prodConsBQ.put(value++);
					i++;
				}
			}

		});

		Thread threadTwo = new Thread(new Runnable() {
			int i = 0;
			@Override
			public void run() {

				while (i < cap) {
					int val = prodConsBQ.get();
					i++;

				}
			}

		});

		threadOne.start();
		threadTwo.start();

		System.out.println("Main Ended");
	}

}
