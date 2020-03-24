package com.capgemini.thread.threadconcept;

public class Irctc {
	public synchronized void confirmTicket() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
		public synchronized void leaveMe() {
			System.out.println("notify is called");
			notifyAll();
		}
	

}
