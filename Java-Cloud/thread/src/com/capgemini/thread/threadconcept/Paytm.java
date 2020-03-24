package com.capgemini.thread.threadconcept;

public class Paytm extends Thread{
    Irctc i;

	public Paytm(Irctc i) {
		this.i = i;
	}
	@Override
	public void run() {
		i.confirmTicket();
	}
    
}
