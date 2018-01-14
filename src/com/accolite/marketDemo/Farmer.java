package com.accolite.marketDemo;

import java.util.Random;

public class Farmer implements Runnable{
	Random random;
	Farmer()
	{
		random = new Random();
	}
	public void run()
	{
		long now = System.currentTimeMillis();
		long time = now - System.currentTimeMillis();
		int fruit;
		while(time < 2*60*1000) // 2 minutes
		{
			fruit = getFruit();
			Market.sell(fruit);//should have static member
		}
	}
	
	private int getFruit()
	{
		return random.nextInt(5);
	}

}
