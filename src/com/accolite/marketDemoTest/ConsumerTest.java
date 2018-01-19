package com.accolite.marketDemoTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.accolite.marketDemo.Consumer;

public class ConsumerTest {
	static Consumer consumer;
	
	@BeforeClass
	public static void testInit() {
		consumer = new Consumer();		
	}
	
	@Test
	public void getConsumerTest() {
		for(int i = 0; i < 10; i++) {
			int c = consumer.getConsumer();
			boolean result = (c >= 0) && (c < 4);
			assertTrue(result);
		}		
	}
	@Test(timeout = 1200)
	public void waitLittleTest() {
		consumer.waitLittle();
	}

}
