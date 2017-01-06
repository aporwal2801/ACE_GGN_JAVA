package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {

	BlockingQueue<Runnable> myBlockingQueue;
	private static final int MAX_SIZE = 1;

	public CustomThreadPool(int nThreads) {
		myBlockingQueue = new ArrayBlockingQueue<Runnable>(MAX_SIZE);

		for (int i = 1; i <= nThreads; i++) {
			ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(
					myBlockingQueue, this);
			threadPoolsThread.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			threadPoolsThread.start(); // start thread
		}
	}

	public static void main(String[] args) throws Exception {
		CustomThreadPool threadPool=new CustomThreadPool(10); 
        Runnable task=new Task();
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.execute(task);

	}
	
	public synchronized void  execute(Runnable task) throws Exception{
        System.out.println("task has been added.");
        this.myBlockingQueue.put(task);
    }

	class ThreadPoolsThread extends Thread {
		private BlockingQueue<Runnable> taskQueue;
		private CustomThreadPool threadPool;

		public ThreadPoolsThread(BlockingQueue<Runnable> queue,
				CustomThreadPool threadPool) {
			taskQueue = queue;
			this.threadPool = threadPool;

		}

		public void run() {
			try {
				while (true) {
					System.out.println(Thread.currentThread().getName()
							+ " is READY to execute task.");
					Runnable runnable = taskQueue.take();
					System.out.println(Thread.currentThread().getName()
							+ " has taken task.");
					runnable.run();
					System.out.println(Thread.currentThread().getName()
							+ " has EXECUTED task.");

				}
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName()
						+ " has been STOPPED.");
			}
		}
	}

	 static class Task implements Runnable{  
		    @Override
		    public void run() {
		           try {
		                  Thread.sleep(2000);
		                  System.out.println(Thread.currentThread().getName()
		                               +" is executing task.");
		           } catch (InterruptedException e) {
		                  e.printStackTrace();
		           }
		    }
		};
}
