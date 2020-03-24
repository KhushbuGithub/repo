package com.testyantra.ombss.main;

import java.util.ArrayList;
import java.util.Scanner;

public class TestA {

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList al = new ArrayList();
		System.out.println("Enter your choice: ");
		/*
		 * System.out.println("1.Admin Module"); System.out.println("2.Visitor module");
		 * System.out.println("3.User module"); System.out.println("4.Payment module");
		 * System.out.println("5.Shopping cart module");
		 */
		int ch = sc.nextInt();
		switch(ch) {
			case 1: System.out.println("1.Add Madicine : ");
			/*
			 * System.out.println("2.Delete Madicine : ");
			 * System.out.println("3.Modify Madicine : ");
			 * System.out.println("4.Remove User Account : ");
			 */
				int n = sc.nextInt();
				if(n==1) {
					if(al!=null) {
						System.out.println("ENter your Name ");
						String name = sc.next();
						System.out.println("Enter your age ");
						int age = sc.nextInt();
						System.out.println("create password ");
						String password = sc.next();
						
						al.add(name);
						al.add(age);
						al.add(password);
					
				}
					for(int i =0;i<al.size();i++) {
						System.out.println("Items "+al.get(i));
					}
			}
		}
	}
}
