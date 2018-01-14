package com.accolite.marketDemo;

import java.util.Queue;

public class Market {
	static int[] market;
	String fruitName;
	static fruitCount;
	static Queue<Integer> farmerQ;
	
	public static void main(String[] args) 
	{
		
				

	}
	public static void getFruit(int fruit)
	{
		checkWaitingFarmer();
		if(market[fruit] < 1)
		{
			market[fruit]--;
			fruitCount--;
			System.out.println("consumer waiting for " + fruitName[fruit]);
		}
		else if(market[fruit] == 1)
		{
			market[fruit]--;
			fruitCount--;
			System.out.println("consumer buy " + fruitName[fruit]);
		}
		else
			System.out.println("Some ERROR");
	}
	public static void sell(int fruit)
	{
		if(fruitCount>5)
		{
			farmerQ.add(fruit);
			System.out.println('farmer waiting to sell' + fruitName[fruit]);
		}
		else
		{
			fruitCount++;
			market[fruit]++;
			System.out.println('farmer place fruit' + fruitName[fruit]);
		}		
	}
	private static checkWaitingFarmer()
	{
		if(fruitCount<5)
		{
			int fruit = farmerQ.remove();
			fruitCount++;
			market[fruit]++;
			System.out.println('farmer place fruit from waiting queue' + fruitName[fruit]);
		}
	}
	
	

}
