package com.sapient.practice.multithreading;

public class DeadLock {
	
	String myString1;
	String myString2;
	
	public DeadLock(String str1, String str2)
	{
		myString1 = str1;
		myString2 = str2;
	}
	
	public void displayMethod1()
	{
		
		System.out.println("In Method displayMethod1");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized(myString2)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Name = "+myString2.toString());	
			
		}
		
	}
	
	public void displayMethod2()
	{
		
		System.out.println("In Method displayMethod2");
	
		synchronized(myString1)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Name = "+myString1.toString());
		}
	}


	public static void main(String[] args) {
		
		String s1 = new String("Varinder");
		String s2 = new String("Sahota");
		
		DeadLock dead = new DeadLock(s1, s2);
		
		Thread threadOne = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" started.");
				while(true)
				{
					synchronized(s1){
						dead.displayMethod1();
					}
						
				}
			}
			
		},"ThreadOne");
		Thread threadTwo = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" started.");
				while(true)
				{
					synchronized(s2){
						dead.displayMethod2();
					}
				}
				
			}
			
		},"ThreadTwo");
		

		threadOne.start();
		threadTwo.start();
		
	}

}
