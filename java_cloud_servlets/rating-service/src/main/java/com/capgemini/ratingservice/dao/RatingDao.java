package com.capgemini.ratingservice.dao;

import java.util.List;

import com.capgemini.ratingservice.beans.BookRating;

public interface RatingDao {

	public BookRating getRating(int Id);

	public List<BookRating> getAllRating();
}
