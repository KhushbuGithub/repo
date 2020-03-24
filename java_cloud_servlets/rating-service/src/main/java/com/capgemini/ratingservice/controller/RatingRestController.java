package com.capgemini.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ratingservice.beans.BookRating;
import com.capgemini.ratingservice.service.RatingService;

@RestController
public class RatingRestController {
	
	@Autowired
	private RatingService service;
	
	@GetMapping(path="/getRating",produces = MediaType.APPLICATION_JSON_VALUE)
	public BookRating getBook(int bookid) {
		return service.getRating(bookid);
		
	}
	
	@GetMapping(path="/getAllRating",produces = MediaType.APPLICATION_JSON_VALUE)
      public List<BookRating> getAllBooks(){
		return service.getAllRating();
	}

}
