package com.capgemini.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.book.Author;
import com.capgemini.springcore.book.Book;
import com.capgemini.springcore.book.Story;

import lombok.extern.java.Log;

@Log
public class AppBook {
	public static void main(String[] args) {
		
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("book.xml");
	 Book book = context.getBean(Book.class);
	 System.out.println(book.getName());
	 
	 Author author =context.getBean(Author.class);
	 System.out.println(author.getPenname());
	 System.out.println(author.getName());
	 
    Story story= context.getBean(Story.class);
    story.tellstory();

}
}