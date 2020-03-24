package com.capgemini.exceptionhandling.customuncheckedexception;

public class ATMStimulator {
	
	double balance=5000;
	public void withdraw(double amt) {
		if(amt>balance) {
			throw new InSufficientBalanceException();
		}else {
			System.out.println("withdraw succesfully");
		}
	}

}
