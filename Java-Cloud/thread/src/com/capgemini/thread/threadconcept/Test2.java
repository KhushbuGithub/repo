package com.capgemini.thread.threadconcept;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t2= new Thread2();
		Thread t1= new Thread(t2);
		t1.start();
//		try {
//			t1.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("main ended");
	}

}
