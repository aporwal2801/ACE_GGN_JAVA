package com.MultiThread.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class PC_ArrayList {

public static void main(String[] args) {

	List<String> bq = new ArrayList<>();
	
	
 Thread t1 = new Thread(new Producer(bq));
 Thread t2 = new Thread(new Consumer(bq));
 t1.start();t2.start();
}
}


class Producer implements Runnable {
	List<String> bq = null;
	
	public Producer(List<String> bq) {
	this.bq = bq;
	}
	
	   void produce() throws InterruptedException {
		   synchronized(bq){
		 while(bq.size()== 5){
			 System.out.println("Producer Waiting");
				bq.wait();
			}
			
		System.out.println("Adding: " +"ABC"+bq.size());
		bq.add("ABC"+bq.size());
		bq.notifyAll();
		   }
	}

	@Override
	public void run() {
	try {
		while(true){
			produce();
			Thread.sleep(500);
			}
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		
	}
	
}


class Consumer implements Runnable {
	List<String> bq = null;
	

	
	public Consumer(List<String> l) {
	this.bq =l; 
	}
	
	 void consume() throws InterruptedException {
		 synchronized(bq){		
		 while(bq.isEmpty()){
			System.out.println("Consumer Waiting");
			bq.wait();
			}
		System.out.println(bq.remove(0));
		bq.notifyAll();
		 }
	}

	@Override
	public void run() {
		try {
		while(true){
			Thread.sleep(100);
			consume();
		
		}		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
