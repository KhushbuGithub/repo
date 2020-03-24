package com.capgemini.thread.threadconcept;

public class Thread1 extends Thread{
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
