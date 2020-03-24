package com.capgemini.bookmydoctor.util;

import java.util.Scanner;


import org.mindrot.jbcrypt.BCrypt;



public class PasswordEncoder {

	
	public static String passwordEncoder(String plainPassword) {
		return BCrypt.hashpw("qwerty", BCrypt.gensalt());
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter password to be encoded....");
		String plainPassword = scanner.nextLine();
		System.out.println(passwordEncoder(plainPassword));
		scanner.close();
	}
}
