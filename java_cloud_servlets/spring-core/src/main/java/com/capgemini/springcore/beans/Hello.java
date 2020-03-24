package com.capgemini.springcore.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class Hello implements InitializingBean, DisposableBean {
	
	public Hello() {
		System.out.println("Hello Object Created");
	}
	public Hello(String message) {
		this.message=message;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method");
	}
	
	
	private String message;
	private Map<Integer,String> map;
	private List<Integer> list;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
           System.out.println("afterPropertiesSet method");		
	}
	

}
