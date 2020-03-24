package com.capgemini.bookmydoctor.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidator {

	
	public static boolean passwordValidator(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the password to be encoded");
		String plainPassword = scanner.nextLine();
		String hashedPassword = PasswordEncoder.passwordEncoder(plainPassword);
		System.out.println(hashedPassword);
		System.out.println("Enter the password to be matched");
		String password = scanner.nextLine();
		if (passwordValidator(password, hashedPassword)) {
			System.out.println("Password Matched..");
		}else {
			System.err.println("Invalid Password");
		}
		scanner.close();
	}
}
