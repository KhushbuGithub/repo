package com.capgemini.springcore.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.BeanFactoryPostProcessorImpl;
import com.capgemini.springcore.beans.BeanPostProcessorImpl;
import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
public class BeanConfig {
	@Bean("hello")
	@Scope("prototype")
public Hello getHello() {
	Hello hello=new Hello();
	hello.setMessage("I love Spring");
	return hello;
	}
	
	@Bean("beanFactoryPostProcessor")
	public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
		return new BeanFactoryPostProcessorImpl();
	}
	@Bean("beanPostProcessor")
	public BeanPostProcessor getBeanPostProcessor() {
		return new BeanPostProcessorImpl();
	}
	
//	@Bean("dog")
//	public Dog getDog() {
//		return new Dog();
//	}
	
	@Bean("cat")
	@Primary         
	public Cat getCat() {
		return new Cat();
	}
//	@Bean("pet")
//	public Pet getPet() {
//		//Pet pet= new Pet("Jinni",getDog()); //wiring by constructer
//		Pet pet = new Pet();
//		/* wiring by reference  */
//		pet.setName("Jinni");
////		pet.setAnimal(getDog());
//		return pet;
//		
//	}

}
