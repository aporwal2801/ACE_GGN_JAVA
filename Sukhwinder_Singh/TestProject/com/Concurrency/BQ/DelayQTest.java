package com.Concurrency.BQ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DelayQTest {

	
	ThreadPoolExecutor p = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
	public static void main(String[] args) {

		Executors.newCachedThreadPool();	
		BlockingQueue<DelayElement> bq =new DelayQueue<DelayElement>();
		
		Thread t = new Thread(new Producer_DQ(bq));
		t.start();
	}

}

class consumer_DQ implements Runnable {

	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

class Producer_DQ implements Runnable{

	BlockingQueue<DelayElement> dBq = null;
	
	public Producer_DQ(BlockingQueue<DelayElement> dBq) {
		this.dBq=dBq;
	}
	@Override
	public void run() {
while(true){
	DelayElement de = new DelayElement("ABS", 1000l);
	try {
		dBq.put(de);
    	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}		
	}}

class DelayElement implements Delayed {

	String val = null;
	Long delayTime = 0L;

	public DelayElement(String v, Long time) {
		this.val = v;
		this.delayTime = time + System.currentTimeMillis();
	}

	public String getVal() {
		return val;
	}

	@Override
	public int compareTo(Delayed o) {
		if (delayTime < ((DelayElement) o).delayTime) {
			return -1;
		}
		if (delayTime > ((DelayElement) o).delayTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		Long t = delayTime - System.currentTimeMillis();
		return unit.convert(t, TimeUnit.MILLISECONDS);
	}

}
