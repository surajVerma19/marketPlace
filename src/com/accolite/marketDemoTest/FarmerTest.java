package com.accolite.marketDemoTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.accolite.marketDemo.Farmer;

public class FarmerTest {
	static Farmer farmer;
	
	@BeforeClass
	public static void testInit() {
		farmer = new Farmer();
	}
	
	@Test
	public void getFruitTest() {
		for(int i = 0; i < 10; i++) {
			int f = farmer.getFruit();
			boolean result = (f >= 0) && (f < 4);
			assertTrue(result);
		}		
	}
	
	@Test(timeout = 1200)
	public void waitLittleTest() {
		farmer.waitLittle();
	}
	
	

}
