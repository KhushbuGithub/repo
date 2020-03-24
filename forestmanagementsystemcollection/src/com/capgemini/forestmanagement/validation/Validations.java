package com.capgemini.forestmanagement.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public static boolean isWord(String name) {
		return (Pattern.matches("[a-zA-Z]+", name));
	}

	public static boolean isNumber(String tel) {
		return Pattern.matches("[0-9]+", tel);
	}

	public static boolean valEmail(String custemail) {

		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailpat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailpat.matcher(custemail);
		return matcher.find();

	}

	public static int countofdigits(int number) {
		int count = 0;
		while (number != 0) {
			number /= 10;
			++count;
		}
		return count;
	}

	public static boolean isValidDate(String date) {
		String dateValid = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{4}$";
		Pattern exp = Pattern.compile(dateValid);
		Matcher match = exp.matcher((CharSequence) date);
		if (match.matches()) {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/mm/yyyy");
			LocalDateTime local = LocalDateTime.now();
			String datee = dateFormat.format(local);
			if (date.compareTo(datee) < 0 || date.compareTo(datee) == 0) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}

	public static boolean deliveryDate(String date) throws ParseException {
		String dateValid = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{4}$";
		Pattern exp = Pattern.compile(dateValid);
		Matcher match = exp.matcher((CharSequence) date);
		if (match.matches()) {
			return true;
		} // compareTo method returns the value 0 if the argument Date is equal to the
			// second Date;
		else {
			// System.err.println("You seem to be a time traveller!!");
			return false;
		}
	}
	//

	public static boolean isValidfuture(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			java.util.Date date = sdf.parse(d); // if date invalid throw exception
			Date today = new Date();
			return date.after(today); // return false if future date
		} catch (Exception e) {
			return true;
		}
	}

	public static boolean DayValid(String day) {

		if (day.equalsIgnoreCase("monday")) {
			return true;
		} else if (day.equalsIgnoreCase("tuesday")) {
			return true;
		} else if (day.equalsIgnoreCase("wednesday")) {
			return true;
		} else if (day.equalsIgnoreCase("thursday")) {
			return true;
		} else if (day.equalsIgnoreCase("friday")) {
			return true;
		} else if (day.equalsIgnoreCase("saturday")) {
			return true;
		} else if (day.equalsIgnoreCase("sunday")) {
			return true;
		} else if (day.equalsIgnoreCase("mon")) {
			return true;
		} else if (day.equalsIgnoreCase("tue")) {
			return true;
		} else if (day.equalsIgnoreCase("wed")) {
			return true;
		} else if (day.equalsIgnoreCase("thu")) {
			return true;
		} else if (day.equalsIgnoreCase("fri")) {
			return true;
		} else if (day.equalsIgnoreCase("sat")) {
			return true;
		} else if (day.equalsIgnoreCase("sun")) {
			return true;
		} else {
			return false;
		}
	}
}
