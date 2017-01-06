package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CustomBlockingQueue<T> {

	private static int MAX = 10;
	private Queue<T> myQueue = null;

	CustomBlockingQueue(Queue<T> myArray) {
		this.myQueue = myArray;
	}

	public void enqueue(T i) throws InterruptedException {
		while (myQueue.size() == MAX) {
			synchronized(this){
			wait();
			}
		}
		myQueue.add(i);
		notify();
	}

	public T denqueue() throws InterruptedException {
		while (myQueue.size() == 0) {
			synchronized(this){
				wait();
				}
		}
		T t = myQueue.remove();
		notify();
		return t;
	}
	
	public int size() {     
	    return this.myQueue.size();
	}

//	public static <T> void main(String[] args) throws InterruptedException {
//
//		List<T> list = new ArrayList<T>();
//		CustomBlockingQueue myQueue = new CustomBlockingQueue(list);
//
//		for (int i = 0; i < 9; i++) {
//			myQueue.enqueue(i);
//		}			
//		
//		System.out.println(myQueue.size());
//		
//		for (int i = 0; i < 5; i++) {
//			myQueue.denqueue();
//		}
//		
//		System.out.println(myQueue.size());
//		
////		for (int i = 0; i < 18; i++) {
////			myQueue.enqueue(i);
////			System.out.println(myQueue.size());
////		}
//	}

}
