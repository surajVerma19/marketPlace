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
			waitLittle();
			fruit = getFruit();
			Market.sell(fruit);//should have static member
			time = now - System.currentTimeMillis();
		}
	}
	
	private int getFruit()
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
