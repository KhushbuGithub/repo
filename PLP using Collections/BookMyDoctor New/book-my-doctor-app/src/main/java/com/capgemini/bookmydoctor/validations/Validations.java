package com.capgemini.bookmydoctor.validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Validations {

	static LinkedList<String> emailList = new LinkedList<String>();

	public static boolean isStringAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public static boolean isEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		} else {

			return pat.matcher(email).matches();
		}

	}

	public static boolean isPassword(String password) {
		String passwordPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		Pattern pat = Pattern.compile(passwordPattern);
		if (password == null) {
			return false;
		} else {
			return pat.matcher(password).matches();
		}
	}

//	public static boolean dateValidation(String d) {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

//		sdf.setLenient(false);
//		try {
//			Date date = sdf.parse(d); // if date invalid throw exception
//			Date today = new Date();
//			return date.after(today); // return false if future date
//		} catch (Exception e) {
//			return true;
//		}
//	}
	public static boolean dateValidation(String d) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy/hh:mm");
		try {
			Date dateFormat = format.parse(d);
			if (dateFormat.compareTo(date) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			System.out.println("invalid date");
			return false;
		}
	}

	public static boolean isNumber(String num) {
		if (num.matches("[0-9]+")) {
			return true;
		}
		return false;

	}

//	public static boolean phoneValidation(int num) {
//
//		int count = 0;
//		while (num > 0) {
//			count++;
//			num = num / 10;
//		}
//		if (count == 10) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}
	public static boolean phoneValidation(String num) {
		String phoneRegex = "(0/91)?[7-9][0-9]{9}";
		Pattern pattern = Pattern.compile(phoneRegex);
		if (num == null) {
			return false;
		}
		return pattern.matcher(num).matches();
	}

	public static boolean validateExistingEmail(String email) {
		for (String eml : emailList) {
			if (eml.equals(email)) {
				return false;
			}
		}
		emailList.add(email);
		return true;
	}
}

//	public static boolean validateDate(String date) throws ParseException {
//		Date dateRef = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		Date inputDate = format.parse(date);
//
//		if (inputDate.compareTo(dateRef) > 0) {
//			return true;
//		}
//		return false;
//
//	}

//public static boolean timeValidate(String num) {
//	(				#start of group #1
//			 1[012]				#  start with 10, 11, 12
//			 |				#  or
//			 [1-9]				#  start with 1,2,...9
//			)				#end of group #1
//			 :				#    follow by a semi colon (:)
//			  [0-5][0-9]			#      follw by 0..5 and 0..9, which means 00 to 59
//			            (\\s)?		#        follow by a white space (optional)
//			                  (?i)		#          next checking is case insensitive
//			                      (am|pm)	#            follow by am or pm
//
//}

//public static void main(String[] args) {
//	LocalTime time = LocalTime.now();
//	System.out.println(time);
//	
//
//	
//}
//	The first digit should contain number between 7 to 9.  FOR PHONE NUMBER
//	The rest 9 digit can contain any number between 0 to 9.
//	The mobile number can have 11 digits also by including 0 at the starting.
//	The mobile number can be of 12 digits also by including 91 at the starting

//(			# Start of group
//		  (?=.*\d)		#   must contains one digit from 0-9
//		  (?=.*[a-z])		#   must contains one lowercase characters
//		  (?=.*[A-Z])		#   must contains one uppercase characters
//		  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
//		  .		#     match anything with previous condition checking
//		  {6,20}	#        length at least 6 characters and maximum of 20	
//		)			# End of group
// VALIDATIONS FOR FEES
//	public static boolean validateFees(int amount) {
//		if (amount >= 200 && amount <= 1000) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			System.out.println("Enter doctor fee");
//			try {
//				int amount = scanner.nextInt();
//				if (validateFees(amount)) {
//					System.out.println("Valid Amount");
//					break;
//				} else {
//					System.out.println("Invalid Amount");
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("Enter only integer value");
//				String a[] = new String[] {"1"};
//				main(a);
//			}
//		}
//		scanner.close();
//	}
//
//}
