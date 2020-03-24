package com.capgemini.jdbc.common2;

import com.capgemini.common.jdbc.Calculator;

public class Test1 {
	public static void main(String[] args) {
		Calculator c= new Calculator();
		int result= c.addition(10,20);
		System.out.println(result);
	}

}
