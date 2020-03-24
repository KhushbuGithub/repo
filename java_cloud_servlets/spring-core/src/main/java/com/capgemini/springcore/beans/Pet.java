package com.capgemini.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.springcore.beans.Animal1;

import lombok.Data;

@Component
@Data
public class Pet {
	public Pet() { }
	public Pet(String name, Animal1 animal) {
		super();
		this.name = name;
		this.animal = animal;
	}
	private String name;
	@Autowired()           //autowire -byType
	//@Qualifier("dog")           //this annotation is used for autowire- byName
	private Animal1 animal;
	

}
