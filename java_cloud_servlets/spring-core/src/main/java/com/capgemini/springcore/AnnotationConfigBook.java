package com.capgemini.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.book.Author;
import com.capgemini.springcore.book.Book;
import com.capgemini.springcore.book.Story;
import com.capgemini.springcore.config.BookConfig;

public class AnnotationConfigBook {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(BookConfig.class);
		
		
		 
		 Author author =context.getBean(Author.class);
		 System.out.println(author.getPenname());
		 System.out.println(author.getName());
		 
	    Story story= context.getBean(Story.class);
	    story.tellstory();
	    
	    Book book = context.getBean(Book.class);
		 System.out.println(book.getName());
		 book.getAuthor().tellstory();
		// context.close();
		 
	    
	}

}
