package com.capgemini.exceptionhandling.exceptionpropagation;

public class D {
	static void q() throws ClassNotFoundException {
		Class.forName("preson");
	}
}
