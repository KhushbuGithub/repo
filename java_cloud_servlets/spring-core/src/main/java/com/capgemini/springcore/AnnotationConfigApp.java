package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal1;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.config.BeanConfig;

import lombok.extern.java.Log;
@Log
public class AnnotationConfigApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Hello hello1=context.getBean(Hello.class);
		log.info(hello1.getMessage());
		
		Hello hello2=context.getBean(Hello.class);
		log.info(Boolean.toString(hello1==hello2));
		
		log.info("***************************************");
		Animal1 animal= context.getBean(Animal1.class); //dependency injection
		animal.makesound();
		
		Pet pet=context.getBean(Pet.class);
		log.info(pet.getName());
		pet.getAnimal().makesound();
		
	
		
		
		
		context.close();
	}

}
