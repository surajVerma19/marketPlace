package com.accolite.marketDemoTest;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import com.accolite.marketDemo.Market;

public class MarketTest {
	@Before
	public void reInit() {
		for(int i =0;i<4;i++)
			Market.marketPlace[i] = i-1;
		Market.fruitCount = 3;
		Market.farmerQ.clear();
	}

	@Test
	public void getFruitTest() {
		Market.marketPlace[3] = 4;
		Market.fruitCount = 5;
		Market.farmerQ.add(2);
		
		Market.getFruit(0);
		assertEquals(-2, Market.marketPlace[0]);
		assertEquals(5, Market.fruitCount);
		assertFalse(Market.farmerQ.isEmpty());
		
		Market.getFruit(1);
		assertEquals(-1, Market.marketPlace[1]);
		assertEquals(5, Market.fruitCount);
		assertFalse(Market.farmerQ.isEmpty());

		Market.getFruit(2);
		assertEquals(1, Market.marketPlace[2]);
		assertEquals(5, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
		
		Market.getFruit(2);
		assertEquals(0, Market.marketPlace[2]);
		assertEquals(4, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
		
		Market.getFruit(3);
		assertEquals(3, Market.marketPlace[3]);
		assertEquals(3, Market.fruitCount);
		
		Market.getFruit(3);
		assertEquals(2, Market.marketPlace[3]);
		assertEquals(2, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
	}
	@Test
	public void sellTest() {
		Market.sell(0);
		assertEquals(0, Market.marketPlace[0]);
		assertEquals(3, Market.fruitCount);
		
		Market.sell(1);
		assertEquals(1, Market.marketPlace[1]);
		assertEquals(4, Market.fruitCount);
		
		Market.sell(2);
		assertEquals(2, Market.marketPlace[2]);
		assertEquals(5, Market.fruitCount);
		
		Market.sell(3);
		assertEquals(2, Market.marketPlace[3]);
		assertEquals(5, Market.fruitCount);
		
		Market.sell(0);
		assertEquals(0, Market.marketPlace[0]);
		assertEquals(5, Market.fruitCount);
	}
	
	@Test
	public void checkWaitingFarmerTest() {
		Market.marketPlace[3] = 4;
		Market.fruitCount = 5;
		Market.farmerQ.add(2);
		
		Market.getFruit(0);
		assertEquals(-2, Market.marketPlace[0]);
		assertEquals(5, Market.fruitCount);
		assertFalse(Market.farmerQ.isEmpty());
		
		Market.getFruit(1);
		assertEquals(-1, Market.marketPlace[1]);
		assertEquals(5, Market.fruitCount);
		assertFalse(Market.farmerQ.isEmpty());

		Market.getFruit(2);
		assertEquals(1, Market.marketPlace[2]);
		assertEquals(5, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
		
		Market.getFruit(2);
		assertEquals(0, Market.marketPlace[2]);
		assertEquals(4, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
		
		Market.getFruit(3);
		assertEquals(3, Market.marketPlace[3]);
		assertEquals(3, Market.fruitCount);
		
		Market.getFruit(3);
		assertEquals(2, Market.marketPlace[3]);
		assertEquals(2, Market.fruitCount);
		assertTrue(Market.farmerQ.isEmpty());
	}
	

}
