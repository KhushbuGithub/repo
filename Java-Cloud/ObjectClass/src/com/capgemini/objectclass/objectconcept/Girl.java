package com.capgemini.objectclass.objectconcept;

public class Girl {
	void receive(Gift g1) {
		if (g1 instanceof Toffee) {
			System.out.println("Idiot");
		}
		else if(g1 instanceof Chocolate) {
			System.out.println("Thankyou");
		}
		else if(g1 instanceof Xioami) {
			System.out.println("Ty dear");
		}
		else if(g1 instanceof Iphone) {
			System.out.println("ILY");
		}
		
	}
	public static void main(String[] args) {
		Girl g=new Girl();
		g.receive(new Iphone());
	}

}
