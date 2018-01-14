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
			consumer = getConsumer();
			Market.getFruit(consumer);//should have static member
		}
	}
	
	private int getConsumer()
	{
		return random.nextInt(5);
	}

}
