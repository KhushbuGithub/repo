package com.capgemini.javacloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ORMConfig {
	@Bean
	public LocalEntityManagerFactoryBean getBean() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("bookmydoctor");
		return bean;

	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
