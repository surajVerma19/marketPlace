package com.accolite.marketDemo;

import java.util.*;

public class Consumer implements Runnable{
	Random random;
	public Consumer()
	{//consumer will be distinguish or identify on the bases of the fruits they want to buy
		//so we generate consumers who wants to buy random fruits
		random = new Random();
	}
	public void run()
	{
		int minutes = 1;	// number of minutes to run the code
		long now = System.currentTimeMillis();	// number of minutes will be count from here
		long timeDiff =  System.currentTimeMillis() - now;	//calculate the time elapsed after 'now'
		int consumer;
		while(timeDiff < minutes*60*1000) //  minutes in milliseconds
		{
			waitLittle();	//control the generation of consumers
			consumer = getConsumer();
			Market.getFruit(consumer);	//go to market to get desired fruit
			timeDiff = System.currentTimeMillis() - now;	//recalculate the time elapsed after 'now'
		}
	}
	
	public int getConsumer()
	{//a consumer will be generate who wants a random fruit
		return random.nextInt(4);	
	}
	public void waitLittle()
	{
		try {
			Thread.sleep(random.nextInt(1000) + 100L);	//randomly wait from 100 to 1100 millisecond
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
