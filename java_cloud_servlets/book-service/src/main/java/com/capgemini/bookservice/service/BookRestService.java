package com.capgemini.bookservice.service;

import java.util.List;

import com.capgemini.bookservice.beans.Book;

public interface BookRestService {
	public Book getBook(int id);

	public List<Book> getAllBook();
	

}
