package com.sapient.practice.collections;

public class CacheObject {

	Object object;
	private long timeToLive = 0;
	private Thread timerDelay = null;

	CacheObject(Object objectVar, long time, Thread timer) {
		object = objectVar;
		timeToLive = time;
		timerDelay = timer;
		
		timerDelay.start();
		System.out.println("Timer Thread Status = "
				+ timerDelay.isAlive());
	}

	public void startThreadDelay() {
		timerDelay.start();
	}

	public long getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(long timeToLive) {
		this.timeToLive = timeToLive;
	}

	public boolean poolTimerExpired() {
		return timerDelay.isAlive();

	}

	public Object getObject() {
		return object;
	}

	public String printObject() {
		return object.toString();
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String toString() {
		return "Cache Object : " + timerDelay.getName();
	}

}
