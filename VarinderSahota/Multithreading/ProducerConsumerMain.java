package com.sapient.practice.multithreading;


public class ProducerConsumerMain {

	public static void main(String[] args) {
		

		System.out.println("Main Started");
		int cap = 3;
		
		ProducerConsumer producerConsumerQueue = new ProducerConsumer(
				cap);

		Thread threadOne = new Thread(new Runnable() {
			int i = 0;
			int value = 11;
			@Override
			public void run() {

				while (i < cap) {
					producerConsumerQueue.putObject(value++);
					i++;
				}
			}

		});

		Thread threadTwo = new Thread(new Runnable() {
			int i = 0;
			@Override
			public void run() {

				while (i < cap) {
					int val = (int) producerConsumerQueue.getObject();
					i++;
				}
			}

		});

		threadOne.start();
		threadTwo.start();

		System.out.println("Main Ended");

	
		
		
	}

}
