package com.capgemini.exceptionhandling.customuncheckedexception;

public class SBIAtmStimulator {
   
	public static void main(String[] args) {
		System.out.println("main started");
		ATMStimulator a1= new ATMStimulator();
		try {
		a1.withdraw(1000);
		}catch(InSufficientBalanceException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}
}
