//write new
package com.Collection;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		
		MyBlockingQueue mq = new MyBlockingQueue(5);
		
		
		Producer p = new Producer(mq);
		Thread t = new Thread(p);
		t.start();
		Consumer c = new Consumer(mq);
		Thread t2 = new Thread(c);
		t2.start();
	
	}
}

class Producer implements Runnable{
	
	MyBlockingQueue mq = null;
	
	public Producer(MyBlockingQueue mq) {
		this.mq=mq;
	}
	
  void	produce() throws InterruptedException{
	  mq.put("A_");
  }

@Override
public void run() {
	try {
		while(true)
		{	this.produce();
		Thread.sleep(500);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}

class Consumer implements Runnable {
	
MyBlockingQueue mq = null;
	
	public Consumer(MyBlockingQueue mq) {
		this.mq=mq;
	}

	@Override
	public void run() {
		try {
			while(true)
			{	this.consume();
			Thread.sleep(500);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

	private void consume() throws InterruptedException {
		System.out.println("Taken :--"+mq.get());;
	
	}
	
	
}


class MyBlockingQueue {

	int counter = 0;
	int listSize = 0;
	List<String> bQ = null;

	
	public int getListSize() {
		return listSize;
	}
	public MyBlockingQueue(int listSize) {
		this.listSize = listSize;
		bQ = new ArrayList<>(listSize);

	}

	synchronized void put(String s) throws InterruptedException {
		while (!(bQ.size() < listSize)) {
			System.out.println("waiting to consume element");
			Thread.sleep(1000);
		}
		bQ.add(0, s+counter);
		System.out.println("Added "+ s +counter);
		counter++;
		
	}

	
	
	synchronized String get() throws InterruptedException {
		while(bQ.size() <= 0) {
			System.out.println("waiting to add element");
			Thread.sleep(1200);
		}
		counter--;
    	return bQ.remove(counter);
		
	}

}