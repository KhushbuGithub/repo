package com.capgemini.ratingservice.service;

import java.util.List;

import com.capgemini.ratingservice.beans.BookRating;

public interface RatingService {
	public BookRating getRating(int Id);

	public List<BookRating> getAllRating();

}
