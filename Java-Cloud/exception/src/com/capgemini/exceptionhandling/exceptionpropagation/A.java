package com.capgemini.exceptionhandling.exceptionpropagation;

public class A {
static void m() throws ClassNotFoundException {
	B.n();
	}
}
