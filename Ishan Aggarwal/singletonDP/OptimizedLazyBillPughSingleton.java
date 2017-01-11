package com.sapient.singleton;

public class OptimizedLazyBillPughSingleton {

	static {
		System.out.println("OptimizedLazySingleton Class Loaded");
	}

	/**
	 * Singleton Instance Wrapper Class.
	 * 
	 * When this class is loaded, the singleton instance will be created. Since
	 * a class is loaded by a given class loader only once, this will ensure
	 * that the Singleton-ness of the singleton will be preserved.
	 * 
	 * Additionally, the class will be loaded on the first reference to it,
	 * which will occur when the getInstance() method is executed for the first
	 * time.
	 */
	private static class SingletonInstanceWrapper {

		static {
			System.out.println("Instance Wrapper Class Loaded");
		}

		/**
		 * Singleton Instance.
		 */
		static final OptimizedLazyBillPughSingleton INSTANCE = new OptimizedLazyBillPughSingleton();
	}

	/**
	 * Guarded Constructor.
	 */
	private OptimizedLazyBillPughSingleton() {

		// Check if we already have an instance
		if (SingletonInstanceWrapper.INSTANCE != null) {
			throw new IllegalStateException("Singleton"
					+ " instance already created.");
		}

		System.out.println("Singleton Constructor Running...");
	}

	/**
	 * Note that this method is no longer synchronized !
	 */
	public static final OptimizedLazyBillPughSingleton getInstance() {
		System.out.println("Returning Singleton...");
		return SingletonInstanceWrapper.INSTANCE;
	}

	public static void main(String s[]) {

		System.out.println("Main method called");
		OptimizedLazyBillPughSingleton instance = OptimizedLazyBillPughSingleton.getInstance();
		System.out.println(instance.hashCode());

	}
}