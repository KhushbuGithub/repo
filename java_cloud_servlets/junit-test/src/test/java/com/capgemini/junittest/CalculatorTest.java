package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator cal;
	
	@BeforeAll
	static void runBeforeAll() {
		System.out.println("Run before all");
	}
	
	@BeforeEach
	void createCalObject() {
		System.out.println("I am before each");
		cal= new  Calculator();
	}
	
	@AfterEach
	void destroyCalObject() {
		System.out.println("I am after each");
		cal= new Calculator();
	}

	@Test
	void addTest() {
		System.out.println("First test case");
		int i= cal.add(6, 5);
		assertEquals(11, i);
	}
	@Test
	 void addNegativeTest() {
		System.out.println("Second test case");
		 int actual =cal.add(-12, -6);
		 int expected=-18;
		 assertEquals(expected, actual);
	 }
	
	@AfterAll
	static void runAfterAll() {
		System.out.println("Run after all");
	}

}
