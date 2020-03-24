package com.capgemini.springcore.book;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Book {
	private String name;
	@Autowired
	// @Qualifier("author")
	private Author author;

	// private Poet poet;

	public String setName() {
		return name;
	}

	public void getName(String name) {
		this.name = name;
	}

	public Book() {

	}

	public Book(String name, Author author) {
		super();
		this.name = name;
		this.author = author;
	}
//	@PostConstruct
//	public void init() {
//		System.out.println("init method");
//	}
//	
//	@PreDestroy
//	public void destroy() {
//		System.out.println("Destroy method");
//	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
}
