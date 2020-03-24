package com.capgemini.springcore.beans;

import org.springframework.stereotype.Component;


@Component
public class Dog implements Animal1{
  
	public void makesound() {
System.out.println("baaaaoooo");		
	}
	


}
