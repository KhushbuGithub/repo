package com.capgemini.thread.threadconcept;

public class TestIrctc {

	public static void main(String[] args) {
		System.out.println("main started");
         Irctc i= new Irctc();
         Paytm p1= new Paytm(i);
         Paytm p2=new Paytm(i);
         
         p1.start();
         p2.start();
         
         try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         i.leaveMe();
         System.out.println("main ended");
         
	}

}
