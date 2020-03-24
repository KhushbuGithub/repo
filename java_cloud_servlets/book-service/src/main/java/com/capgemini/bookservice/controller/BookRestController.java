package com.capgemini.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookservice.beans.Book;
import com.capgemini.bookservice.service.BookRestService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRestService service;
	
	@GetMapping(path="/getBook",produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBook(int bookid) {
		return service.getBook(bookid);
		
	}
	
	@GetMapping(path="/getAllBooks",produces = MediaType.APPLICATION_JSON_VALUE)
      public List<Book> getAllBooks(){
		return service.getAllBook();
	}
}
