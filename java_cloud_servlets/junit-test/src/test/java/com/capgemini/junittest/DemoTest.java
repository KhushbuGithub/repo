package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Its a sample test class")
class DemoTest {

	@Test
	@DisplayName("To test add method of calculator")
	void addtest() {
		Calculator cal = new Calculator();
		int i=cal.add(10, 5);
		assertEquals(15, i);
	}
	@Test
	@DisplayName("To test add method for Negative Values")
	void addNegativetest() {
		Calculator cal = new Calculator();
		int i=cal.add(-10, -5);
		assertEquals(-15, i);
	}

	@Test
	@Disabled
	void subtractTest() {
		
	}
	
}
