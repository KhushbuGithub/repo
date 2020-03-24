package com.capgemini.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleCalTest {
	
	@Test
	void divByZeroTest() {
		SimpleCal cal = new SimpleCal();
		assertThrows(ArithmeticException.class, ()->{
			cal.div(30, 0);
		});
	}

	@Test
	void Divisiontest() {
		SimpleCal cal = new SimpleCal();
		int actual = cal.div(30, 5);
		int expected = 6;
		assertEquals(expected, actual);
	}
	@Test
	void negativeDivisiontest() {
		SimpleCal cal= new SimpleCal();
		int actual=cal.div(-30, -2);
		int expected =15;
		assertEquals(expected, actual);
		
	}

}
