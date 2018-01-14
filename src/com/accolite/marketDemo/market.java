package com.accolite.marketDemo;

import java.util.LinkedList;
import java.util.Queue;

public class Market {
	static int[] market = {0,0,0,0,0};
	static String[] fruitName = {"apple","orange","grape","watermelon"};
	static int fruitCount = 0;
	static Queue<Integer> farmerQ= new LinkedList<Integer>();
	
	public static void main(String[] args) 
	{
		Thread consumer = new Thread(new Consumer());
		Thread farmer = new Thread(new Farmer());
		consumer.start();
		farmer.start();
	}
	
	public static void getFruit(int fruit)
	{
		if(market[fruit] < 1)
		{
			market[fruit]--;
			//fruitCount--;
			System.out.println("consumer waiting for " + fruitName[fruit]);
		}
		else
		{
			market[fruit]--;
			fruitCount--;
			System.out.println("consumer buy " + fruitName[fruit]);
		}
		checkWaitingFarmer();
	}
	public static void sell(int fruit)
	{
		if(fruitCount>5)
		{
			farmerQ.add(fruit);
			System.out.println("farmer waiting to sell" + fruitName[fruit]);
		}
		else
		{
			System.out.println("farmer place fruit" + fruitName[fruit]);
			market[fruit]++;
			if(market[fruit] > 0)
				fruitCount++;
			checkWaitingConsumer(fruit);			
		}

	}
	private static void checkWaitingFarmer()
	{
		if(!farmerQ.isEmpty())
		if(fruitCount<5)
		{
			
			int fruit = farmerQ.remove();
			fruitCount++;
			market[fruit]++;
			System.out.println("farmer place fruit from waiting queue" + fruitName[fruit]);
			checkWaitingConsumer(fruit);
		}
		
	}
	private static void checkWaitingConsumer(int fruit)
	{
		if(market[fruit] < 0)
		{
			System.out.println("consumer buys fresh fruits " + fruitName[fruit]);
		}
	}
}
