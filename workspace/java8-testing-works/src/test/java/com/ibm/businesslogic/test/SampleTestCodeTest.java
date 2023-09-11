package com.ibm.businesslogic.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SampleTestCodeTest {

	
	@BeforeAll
	static void initiatlize() {
		System.out.println("This is before any initialization");
	}
	
	@AfterAll
	static void tearDownLast() {
		System.out.println("This is the last method to be called.. ");
	}
	
	
	@BeforeEach
	public void setUp() {
		System.out.println("Before Each Method");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("After each method ");
	}
	
	@Test
	void simpleTest() {
		System.out.println("Test case ");
		assertEquals(true, true);
	}
	
	@Test
	void simpleTest1() {
		System.out.println("Test case ");
		assertEquals(true, true);
	}

}
