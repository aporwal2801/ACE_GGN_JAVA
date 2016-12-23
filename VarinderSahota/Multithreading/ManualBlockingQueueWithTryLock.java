package com.sapient.practice.multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManualBlockingQueueWithTryLock<E> {
	List<E> newList = null;
	int capacity = 0;

	Lock lock = new ReentrantLock();
	Condition fullCondition = lock.newCondition();
	Condition emptyCondition = lock.newCondition();

	ManualBlockingQueueWithTryLock(List<E> list, int cap) {
		newList = list;
		capacity = cap;
	}

	public int getValue() {
		int tempValue = 0;
		lock.lock();
		try {
			while (newList.size() == 0) {
				try {
					System.out.println(" Consumer Waiting Capacity is zero = "
							+ newList.size());
					fullCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			tempValue = (int) newList.remove(newList.size() - 1);
			System.out.println("Consumer consumed value = " + tempValue);
			emptyCondition.signal();
			return tempValue;
		} finally {
			lock.unlock();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void putValue(E value) {

		lock.lock();
		try {
			while (newList.size() == capacity - 1) {
				try {
					System.out.println(" Producer Waiting Capacity Full = "
							+ newList.size());
					emptyCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			newList.add(value);
			System.out.println("Producer produced value = " + value);
			fullCondition.signal();
		} finally {
			lock.unlock();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		System.out.println("Main Started");
		List list = new LinkedList();

		ManualBlockingQueueWithTryLock ManualBlockingQueue = new ManualBlockingQueueWithTryLock(
				list, 3);

		Thread threadOne = new Thread(new Runnable() {
			int i = 11;

			@Override
			public void run() {

				while (true) {
					ManualBlockingQueue.putValue(i++);
				}
			}

		});

		Thread threadTwo = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					int val = ManualBlockingQueue.getValue();

				}
			}

		});

		threadOne.start();
		threadTwo.start();

		System.out.println("Main Ended");

	}

}
