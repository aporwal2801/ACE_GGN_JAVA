package com.sapient.practice.multithreading;

public class ProducerConsumer <E>{

	 Object[] objectList = null;
	 private volatile int i = 0;
	 final int size;
	 
	 ProducerConsumer(int sz)
	 {
		size = sz;
		objectList = new Object[size];
	 }
	
	 public void putObject(E object)
	 {
		synchronized (objectList)
		{
			
			while(i == size)
				{
					try {
						objectList.wait();
						System.out.println("Producer Waiting as List is Full");
					} catch (InterruptedException e) {
					}
				}
				
				 objectList[i] = new Object();
				 objectList[i] = object;
				 System.out.println("Item added : "+object.toString());
				 i++;
				 System.out.println("Producer Size :"+i);
				 objectList.notifyAll();
				
				}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	 }
	 
	 public E getObject()
	 {
		 E resultObject = null;
		 synchronized (objectList)
		{
			 while(i == 0)
				{
					try {
						objectList.wait();
						System.out.println("Consumer Waiting as List is Empty");
					} catch (InterruptedException e) {
					}
				}
				
				 resultObject = (E) objectList[--i];
				 System.out.println("Item retrived : "+resultObject.toString());
				 System.out.println("Consumer Size :"+i);
				 objectList.notifyAll();
				
				}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 return resultObject;
		
	 }
}
