package com.capgemini.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal1;
import com.capgemini.springcore.beans.Pet;

public class XmlComponentScanApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
		
	        Animal1 animal = context.getBean(Animal1.class);
	        animal.makesound();
	        
	        Pet pet= context.getBean(Pet.class);
	        System.out.println(pet.getName());
	        pet.getAnimal().makesound();

					
			
			

			
		}
	

}
