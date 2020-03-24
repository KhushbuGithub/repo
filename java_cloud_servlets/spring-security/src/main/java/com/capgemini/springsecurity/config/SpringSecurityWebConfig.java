package com.capgemini.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter{
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
		InMemoryUserDetailsManager inMemoryManager= new InMemoryUserDetailsManager();
	
	inMemoryManager.createUser(
			User.withDefaultPasswordEncoder()
			.username("user").password("abcd").roles("user").build());
			
	inMemoryManager.createUser(
			User.withDefaultPasswordEncoder()
			.username("admin").password("abcd").roles("admin").build());
	
	return inMemoryManager;
	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/index").permitAll()
		 .and()
		 .authorizeRequests()
		 .antMatchers("/adminHomePage").hasRole("admin")
		 .and()
		 .authorizeRequests()
		 .antMatchers("/userHomePage").hasAnyRole("user","admin")
		 .and()
		 .formLogin().loginPage("/login")
		 .and()
		 .logout().logoutSuccessUrl("/index");

	}
}
