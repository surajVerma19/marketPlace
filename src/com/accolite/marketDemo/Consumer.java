package com.accolite.marketDemo;

import java.util.*;

public class Consumer implements Runnable{
	Random random;
	Consumer()
	{
		random = new Random();
	}
	public void run()
	{
		long now = System.currentTimeMillis();
		long time = now - System.currentTimeMillis();
		int consumer;
		while(time < 2*60*1000) // 2 minutes
		{
			waitLittle();
			consumer = getConsumer();
			Market.getFruit(consumer);//should have static member
			time = now - System.currentTimeMillis();
		}
	}
	
	private int getConsumer()
	{
		return random.nextInt(4);
	}
	void waitLittle()
	{
		try {
			Thread.sleep(random.nextInt(1000)+100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
