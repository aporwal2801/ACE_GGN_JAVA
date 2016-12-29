package com.sapient.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool<E> {

	private BlockingQueue<Runnable> workerQueue;
	private List<ThreadPoolTasks<E>> threads = new ArrayList<ThreadPoolTasks<E>>();
	boolean stopFlag;

	public ThreadPool(int capacity, int threadSize) {
		this.workerQueue = new ArrayBlockingQueue<>(capacity);

		for (int i = 0; i < capacity; i++) {
			ThreadPoolTasks task = new ThreadPoolTasks(this.workerQueue);
			threads.add(task);
		}

		for (ThreadPoolTasks<E> th : threads)
			th.start();
	}

	public synchronized void execute(Runnable task) throws InterruptedException {
		if (stopFlag)
			throw new IllegalStateException("Thread Pool is stopped");
		workerQueue.put(task);

	}
	
	public synchronized void doStop(){
		this.stopFlag = true;
		for(ThreadPoolTasks thread : threads)
			thread.stopThread();
	}
}
