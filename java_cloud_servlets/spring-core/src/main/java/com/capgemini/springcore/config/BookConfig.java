package com.capgemini.springcore.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.BeanFactoryPostProcessorImpl;
import com.capgemini.springcore.beans.BeanPostProcessorImpl;
import com.capgemini.springcore.book.Author;
import com.capgemini.springcore.book.Book;
import com.capgemini.springcore.book.Poet;
import com.capgemini.springcore.book.Story;

@Configuration
public class BookConfig {
	
	@Bean("book")
	@Scope("prototype")
	public Book getBook() {
		Book book = new Book();
		book.setName("The Book");
		return book;
	}
	@Bean("author")
	@Primary
	public Author getAuthor() {
		return new Author();
	}
	@Bean("poet")
	public Poet getPoet() {
		return new Poet();
	}
	@Bean("beanFactoryPostProcessor")
	public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
		return new BeanFactoryPostProcessorImpl();
	}
	@Bean("beanPostProcessor")
	public BeanPostProcessor getBeanPostProcessor() {
		return new BeanPostProcessorImpl();
	}
	

}
