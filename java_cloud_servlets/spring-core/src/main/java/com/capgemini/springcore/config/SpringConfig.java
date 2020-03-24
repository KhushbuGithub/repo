package com.capgemini.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import(BeanConfig.class)
//@ComponentScan(basePackages="com.capgemini.springcore.book")
  @ComponentScan(basePackages="com.capgemini.springcore.beans")
public class SpringConfig {
	

}
