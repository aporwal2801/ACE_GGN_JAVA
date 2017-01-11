package com.sapient.singleton;

public class DoubleCheckLockingSingleton {

	private static volatile DoubleCheckLockingSingleton instance;

	private DoubleCheckLockingSingleton() {
	}

	public static DoubleCheckLockingSingleton getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckLockingSingleton();
				}
			}
		}
		return instance;
	}
}
