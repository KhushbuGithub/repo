package com.capgemini.dateandtime.dateandtimeapiconcept;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime1 {
	public static void main(String[] args) {
		
	LocalDate l1=  LocalDate.now();
	System.out.println(l1);
	
	LocalDateTime l2 =  LocalDateTime.now();
	System.out.println(l2);
	
	String s1= "2020-01-10";
	LocalDate l3= LocalDate.parse(s1);
	System.out.println(l3);
	
	DateTimeFormatter d1= DateTimeFormatter.ofPattern("E,dd/MMM/yyyy HH:mm:ss a");
	
	String l4=d1.format(l2);
	System.out.println(l4);

}
}