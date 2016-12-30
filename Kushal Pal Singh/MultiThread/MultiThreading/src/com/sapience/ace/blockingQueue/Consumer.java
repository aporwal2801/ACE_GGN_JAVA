package com.sapience.ace.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{

	private BlockingQueue<Task> tasks;

	@Override
	public void run()
	{
		try
		{
			while (!tasks.isEmpty())
			{
				String msg=tasks.take().getMsg();
				System.out.println("Consume task "+msg);
				Thread.sleep(300);
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Consumer(BlockingQueue<Task> tasks)
	{
		super();
		this.tasks = tasks;
	}

}
