package com.capgemini.thread.threadconcept;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			
			System.out.println(i);		
		}
	}
	

}
