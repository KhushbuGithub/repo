package com.capgemini.exceptionhandling.exceptionpropagation;

public class C {
	static void p() throws ClassNotFoundException {
		D.q();
	}

}
