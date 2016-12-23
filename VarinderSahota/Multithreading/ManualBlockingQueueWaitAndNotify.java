package com.sapient.practice.multithreading;

import java.util.LinkedList;
import java.util.List;

public class ManualBlockingQueueWaitAndNotify<E> {
	List<E> newList = null;
	int capacity = 0;

	ManualBlockingQueueWaitAndNotify(List<E> list, int cap) {
		newList = list;
		capacity = cap;
	}

	public int getValue() {
		int tempValue = 0;

		synchronized (newList) {
			while (newList.size() == 0) {

				try {
					System.out.println(" Consumer Waiting Capacity is zero = "
							+ newList.size());
					newList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			tempValue = (int) newList.get(newList.size() - 1);
			newList.remove(newList.size() - 1);
			newList.notifyAll();
			System.out.println("Consumer consumed value = " + tempValue);

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return tempValue;
	}

	public void putValue(E value) {
		synchronized (newList) {
			while (newList.size() == capacity - 1) {
				try {
					System.out.println(" Producer Waiting Capacity Full = "
							+ newList.size());
					newList.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			newList.add(value);
			System.out.println("Producer produced value = " + value);
			newList.notifyAll();

		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Main Started");
		List list = new LinkedList();
		ManualBlockingQueueWaitAndNotify ManualBlockingQueue = new ManualBlockingQueueWaitAndNotify(
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
