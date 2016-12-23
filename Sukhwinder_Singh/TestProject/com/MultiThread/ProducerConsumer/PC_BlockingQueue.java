package com.MultiThread.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PC_BlockingQueue {

	public static void main(String[] args) {
	
		BlockingQueue<String> bq = new  ArrayBlockingQueue<String>(5);
		
		Thread t1 = new Thread(new Producer_BQ(bq));
		Thread t2 = new Thread(new Consumer_BQ(bq));
		t1.start(); t2.start();
	}

	
}

 class Producer_BQ implements Runnable{
	
	BlockingQueue<String> bq = null;
	
	public Producer_BQ(BlockingQueue<String> bq) {
		this.bq=bq;
	}

	
	@Override
	public void run() {
	while(true){
		try {
			double i =Math.random();
			System.out.println("Adding: " +i);
			Thread.sleep(1000);
			bq.put(Double.toString(i));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	}
}
class Consumer_BQ implements Runnable{

	BlockingQueue<String> bq = null;
	
	public Consumer_BQ(BlockingQueue<String> bq) {
		this.bq=bq;
	}
	@Override
	public void run() {
	while(true){
		try {
			System.out.println("Removing: "+bq.take());;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	}
	
}