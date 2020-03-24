package com.capgemini.springcore;

import javax.swing.Spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal1;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.book.Book;
import com.capgemini.springcore.book.Story;
import com.capgemini.springcore.config.SpringConfig;

public class AnnotationComponentScanApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		Animal1 animal= context.getBean(Animal1.class);
		animal.makesound();
		
		Hello hello =context.getBean(Hello.class);
		System.out.println(hello.getMessage());
		
		 Pet pet=context.getBean(Pet.class);
		 System.out.println(pet.getName());
		 pet.getAnimal().makesound();
		 
//		 AnnotationConfigApplicationContext context1= new AnnotationConfigApplicationContext(SpringConfig.class);
//		 
//		 Story story= context1.getBean(Story.class);
//		 story.tellstory();
//		 Book book= context1.getBean(Book.class);
//		 System.out.println(book.getName());
//		 book.getAuthor().tellstory();
//		 
	}

}
