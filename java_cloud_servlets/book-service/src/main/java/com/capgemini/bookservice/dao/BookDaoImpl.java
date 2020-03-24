package com.capgemini.bookservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.bookservice.beans.Book;

@Repository
public class BookDaoImpl implements BookDAO {
	
	private static List<Book> bookDB= new ArrayList<>();
	
	static {
		Book book1= new Book(1,"OCA","Kathy Sierra");
		Book book2= new Book(2,"Java-Black Book","Steven");
		
		bookDB.add(book1);
		bookDB.add(book2);
	}

	@Override
	public Book getBook(int Id) {
		for(Book book:bookDB) {
			if(book.getBookId()== Id) {
				return book;
			}
		}
		return null;
		
	}

	@Override
	public List<Book> getAllBook() {
		return bookDB;
	}
	

}
