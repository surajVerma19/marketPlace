package com.accolite.marketDemo;

import java.util.LinkedList;
import java.util.Queue;

public class Market {
	//marketPlace have capacity of five fruits
	//each index represent type of fruit and and its value represent its quantity 
	
	static public int[] marketPlace = {0,0,0,0}; 
	static String[] fruitName = {"apple","orange","grape","watermelon"};	//a map of number(index) to fruit
	static public int fruitCount = 0;	// number of fruit in market place which is initially zero (min value = 0 and max value = marketCapacity)
	static int marketCapacity = 5;	// maximum capacity of marketPlace
	public static Queue<Integer> farmerQ= new LinkedList<>();	//if marketPlace is full farmer will be wait in queue for there turn
	
	public static void main(String[] args) 
	{
		Thread consumer = new Thread(new Consumer());
		Thread farmer = new Thread(new Farmer());
		consumer.start();
		farmer.start();
	}
	
	public static void getFruit(int fruit)
	{
		//consumer get fruit from marketPlace when fruit is available that is quantity of desired fruit is greater 
		//if desired fruit is not present consumer will wait for it and its status is presented in market place by 
		//negative value and this negative value reepresent the number of consumer waiting for that fruit
		if(marketPlace[fruit] < 1)
		{
			marketPlace[fruit]--;
			System.out.println("consumer waiting for " + fruitName[fruit]);
			displayMarketStatus();
		}
		//if desired fruit is present at marketPlace then consumer will get it and fruit count will get decrement 
		else
		{
			marketPlace[fruit]--;
			fruitCount--;
			System.out.println("consumer buy " + fruitName[fruit]);
			displayMarketStatus();
			//As marketPlace got space for next fruit it will check the waiting farmer
			checkWaitingFarmer();
		}
		
	}
	public static void sell(int fruit)
	{
		//if market is at its capacity then farmer's fruit have to wait in queue to place their fruit 
		if(fruitCount == marketCapacity)
		{
			farmerQ.add(fruit);
			System.out.println("farmer waiting to sell " + fruitName[fruit]);
			displayMarketStatus();
		}
		//else space is available and farmer will put his fruit at marketPlace to sell
		//and as negative value show the consumer waiting for that fruit so it will consume immediately and release 
		//the consumer from waiting and hence fruit count will not increase
		//if no one is waiting for that fruit then fruit count will increase as it will be present at the marketPlace
		else
		{
			System.out.println("farmer put " + fruitName[fruit]);
			marketPlace[fruit]++;
			//if no one is waiting for the fresh fruit then fruit count of marketPlace will increase
			if(marketPlace[fruit] > 0) {
				fruitCount++;
				//this will check if any consumer is waiting for freshly available fruits
				//checkWaitingConsumer(fruit);	//not required as waiting consumer marked its presence as negative value	
			}
			//waiting customer buy it and fruit count will not increase
			else {
				System.out.println("consumer buy fresh " + fruitName[fruit]);//consumer release from waiting
			}
			displayMarketStatus();
		}

	}
	public static void checkWaitingFarmer()
	{
		//if no farmer is waiting or marketPlace is not empty then no need to do anything, although we will call
		//this function only when there is space available in marketPlace so no need to check 'fruitCount'
		if((!farmerQ.isEmpty()) && fruitCount<=5)
		{
			//get the fruit from the queue
			int fruit = farmerQ.remove();
			System.out.println("farmer place fruit from waiting queue " + fruitName[fruit]);
			marketPlace[fruit]++;
			//if no one is waiting for the fruit then fruitcount at marketPlace will increase
			if(marketPlace[fruit] > 0)
				fruitCount++;
			//waiting customer will buy it immediately and so fruit count will not increase
			else {
				System.out.println("THE customer buy fresh " + fruitName[fruit]);//consumer release from waiting
			}
			displayMarketStatus();
		}
	}
	
	static void displayMarketStatus() {
		System.out.print("MARKETPLACE>>>");
		for (int i=0;i<4;i++)
			System.out.print(fruitName[i] + " : "+marketPlace[i]+"	");
		System.out.println("\nfruitCount: " +fruitCount);
		System.out.println("FARMER QUEUE "+farmerQ);
		System.out.println("\n");	
	}	
}
