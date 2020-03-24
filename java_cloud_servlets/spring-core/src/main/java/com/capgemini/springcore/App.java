package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal1;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

import lombok.extern.java.Log;

@Log
public class App 
{
    public static void main( String[] args ) {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	
    	Hello hello1= context.getBean(Hello.class);
    	log.info(hello1.getMessage());
    	log.info(hello1.getMap().toString());
    	log.info(hello1.getList().toString());
    	
    	Hello hello2=context.getBean(Hello.class);
    	log.info(hello2.getMessage());
    	log.info(Boolean.toString(hello1==hello2));
    	log.info("*************************");
    	 
    	Animal1 animal= context.getBean(Animal1.class);
    	animal.makesound();
    	
    	Pet pet=context.getBean(Pet.class);
    	log.info(pet.getName());
    	pet.getAnimal().makesound();
    	
    	context.close();
    }
}
