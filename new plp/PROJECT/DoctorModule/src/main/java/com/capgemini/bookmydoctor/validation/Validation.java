package com.capgemini.bookmydoctor.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Validation {
	
	public static boolean isAge(double num) {
	String age=Double.toString(num);
	String regx = ("^\\d+(\\.\\d{1,2})?$");
	Pattern pattern = Pattern.compile(regx);
	Matcher matcher = pattern.matcher(age);
	if(matcher.matches()) {
		return true;
	}
	return false;
		
	}
	

	public static boolean isName(String input)
	{
		return (Pattern.matches("(?i)[a-z]+(\\s+[a-z]+)*", input));
	}
	
	public static boolean isEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		if(email == null)
			return false;
		else
			return pattern.matcher(email).matches();
	}

	public static boolean isMob(Long num) {
		String phonenum=Long.toString(num);
		String regx = ("^[6-9][0-9]{9}");
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(phonenum);
		if(matcher.matches()) {
			return true;
		}
		return false;
		}

	public static boolean isId(int input1) {
		String num = Integer.toString(input1);
		String regex1 = ("[0-9][0-9]*");
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(num);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static boolean isPortalCode(int portalCode) {
		String code = Integer.toString(portalCode);
		String regx = ("^\\d{3}\\s?\\d{3}$");
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(code);
		if(matcher.matches()) {
			return true;
		}
		return false;
     }


	public static boolean isAddress(String input)
	{
		String regx2=("^[#.0-9a-zA-Z\\s,-]+$");
		Pattern pattern = Pattern.compile(regx2);
		Matcher matcher = pattern.matcher(input);
		return (matcher.equals(matcher));
	}



	public static boolean isUsername(String input1) {
		String user = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
		Pattern pattern = Pattern.compile(user);
		Matcher matcher = pattern.matcher((CharSequence) input1);
		return matcher.matches();

	}

	public static boolean isPassword(String input1) {
		return (Pattern.matches("((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", input1));
	}

	public static boolean isDate(String input)
	{
		Pattern pattern = Pattern.compile("((?:19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])");
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches()) {
			Date date1= null;
			try {
				date1=new SimpleDateFormat("yyyy-MM-dd").parse(input);
			}catch (ParseException e) {
				System.out.println("please enter valid date");
			}
			if(new Date().before(date1)) {
				return true;
			}
		}
		return false;
	}

}
