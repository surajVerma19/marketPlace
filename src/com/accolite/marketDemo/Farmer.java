package com.accolite.marketDemo;

import java.util.Random;

public class Farmer implements Runnable{
	Random random;
	public Farmer()
	{//farmer will be identify or distinguish on the basis of the fruit the produce
		//so we generate different farmers who produced random fruit
		random = new Random();
	}
	public void run()
	{
		int minutes = 1;	//number of minutes to run the code
		long now = System.currentTimeMillis();	// number of minutes will be count from here
		long time = System.currentTimeMillis() - now;	//calculate the time elapsed after 'now'
		int fruit;
		while(time < minutes*60*1000) // run for 'minutes'
		{
			waitLittle();	//control the generation of fruits
			fruit = getFruit();	//get random fruit
			Market.sell(fruit);//should have static member
			time = System.currentTimeMillis() - now;	//recalculate the time relapsed after 'now'
		}
	}
	
	public int getFruit()
	{//a farmer will be generate who produce random fruit
		return random.nextInt(4);
	}
	public void waitLittle()
	{
		try {
			Thread.sleep(random.nextInt(900) + 100L);	//randomly wait from 100 to 1000 millisecond
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
