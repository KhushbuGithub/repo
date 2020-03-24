package com.capgemini.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookservice.beans.Book;
import com.capgemini.bookservice.dao.BookDAO;

@Service
public class BookRestServiceImpl implements BookRestService {

	@Autowired
	private BookDAO dao;

	@Override
	public Book getBook(int id) {
		if (id > 0)
			return dao.getBook(id);
		else
			return null;
	}

	@Override
	public List<Book> getAllBook() {
		return dao.getAllBook();
	}

}
