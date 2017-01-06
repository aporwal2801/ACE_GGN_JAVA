package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerTest {

	static class Producer implements Runnable {

		CustomBlockingQueue<Integer> myCustomBlockingQueue;

		public Producer(CustomBlockingQueue<Integer> myCustomBlockingQueue) {
			this.myCustomBlockingQueue = myCustomBlockingQueue;
		}

		@Override
		public void run() {
			try {
				Random ran = new Random();
				while (true) {
					Integer i = ran.nextInt();
					System.out.println("Produced :" + i);
					myCustomBlockingQueue.enqueue(i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class Consumer implements Runnable {

		CustomBlockingQueue<Integer> myCustomBlockingQueue;

		public Consumer(CustomBlockingQueue<Integer> myCustomBlockingQueue) {
			this.myCustomBlockingQueue = myCustomBlockingQueue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("Consumed:"
							+ myCustomBlockingQueue.denqueue());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> list = new LinkedList<Integer>();
		CustomBlockingQueue<Integer> myCustomBlockingQueue = new CustomBlockingQueue<>(
				list);

		Thread t1 = new Thread(new Producer(myCustomBlockingQueue));
		Thread t2 = new Thread(new Consumer(myCustomBlockingQueue));

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
