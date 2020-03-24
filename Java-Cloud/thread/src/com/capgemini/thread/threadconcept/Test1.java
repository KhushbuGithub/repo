package com.capgemini.thread.threadconcept;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("main started");
		Thread1 t1= new Thread1();
		Thread1 t2= new Thread1();
		t1.start();
		t2.start();
		
		
//		
//		try {
//			t1.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("main ends");
	}

}
