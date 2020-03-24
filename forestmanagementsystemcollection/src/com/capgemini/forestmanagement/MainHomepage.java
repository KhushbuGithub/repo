package com.capgemini.forestmanagement;

import java.util.Scanner;

public class MainHomepage {
	public static void main(String[] args) {

	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("-------------------------------------");
		System.out.println("WELCOME TO FORESTRY MANAGEMANT SYSTEM");
		System.out.println("-------------------------------------");

	    while(true) {
	    System.out.println("Enter Username : ");
	    String username = sc.next();

	   // Scanner input2 = new Scanner(System.in);
	    System.out.println("Enter Password : ");
	    String password = sc.next();

	    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

	    	System.out.println("");
			System.out.println("-----------------");
			System.out.println("   LOGIN PAGE    ");
			System.out.println("-----------------");
			System.out.println("");
			Home.home();
	        
	    }
	    else {
	    	System.out.println("Invalid credentials please enter valid credentials ");
	    }
}
		
	}

}
