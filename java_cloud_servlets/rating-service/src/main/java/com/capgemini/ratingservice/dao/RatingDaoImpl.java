package com.capgemini.ratingservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.ratingservice.beans.BookRating;

@Repository
public class RatingDaoImpl implements RatingDao {

	private static List<BookRating> bookDB = new ArrayList<>();

	static {
		BookRating book1 = new BookRating(1, 8);
		BookRating book2 = new BookRating(2, 9);

		bookDB.add(book1);
		bookDB.add(book2);
	}

	@Override
	public BookRating getRating(int Id) {
		for (BookRating book : bookDB) {
			if (book.getBookId() == Id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<BookRating> getAllRating() {
		return bookDB;
	}

}
