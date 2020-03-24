package com.capgemini.objectclass.objectconcept;

public class KotakBankATM_Machine {
	
void withdraw(Atm a1) {
		
		
		if (a1 instanceof Hdfc) {
			System.out.println("Thanks for using HDFC");	
		}
		else if(a1 instanceof Sbi){
			System.out.println("SBI");
		}
		else if(a1 instanceof Icici) {
			System.out.println("Icici");
		}
			
		}
 

 public static void main(String[] args) {
	 KotakBankATM_Machine k1= new KotakBankATM_Machine();
	 k1.withdraw(new Icici());
	
}
}
