package com.sapient.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		ThreadSafeSingleton newInstance = null;
		ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
		System.out.println("My original instance: " + instance.hashCode());

		Constructor<?>[] declaredConstructors = ThreadSafeSingleton.class
				.getDeclaredConstructors();

		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			newInstance = (ThreadSafeSingleton) constructor.newInstance();
		}
		System.out.println("My new instance: " + newInstance.hashCode());
	}

}
