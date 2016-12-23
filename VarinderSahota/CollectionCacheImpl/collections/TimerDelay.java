package com.sapient.practice.collections;

public class TimerDelay implements Runnable {

	public long time;

	TimerDelay(long timeDelay) {
		time = timeDelay;
	}

	@Override
	public void run() {
		try {
			System.out.println("Timer Delay started "
					+ Thread.currentThread().getName());
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
