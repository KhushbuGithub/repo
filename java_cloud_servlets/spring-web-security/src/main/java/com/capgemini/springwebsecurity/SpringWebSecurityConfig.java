package com.capgemini.springwebsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/index","/register").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/adminHomePage").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/userHomePage").hasRole("USER")
		.and()
		.formLogin()
		.and()
		.logout().logoutSuccessUrl("/index");
	}

}
