package com.capgemini.springrestsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.springrestsecurity.filter.CustomUsernamePasswordAuthenticationFilter;
import com.capgemini.springrestsecurity.handler.MyLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringRestSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccesshandler;
	
//	@Autowired
//	private AuthenticationFailureHandler authenticationFailureHandler;

	@Bean
	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}
	
	@Autowired
	private MyLogoutSuccessHandler myLogoutSuccessHandler;
	
	@Bean
     public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter() throws Exception{
    	CustomUsernamePasswordAuthenticationFilter filter= new CustomUsernamePasswordAuthenticationFilter();
    	filter.setAuthenticationSuccessHandler(authenticationSuccesshandler);
    	filter.setAuthenticationFailureHandler(getAuthenticationFailureHandler());
    	filter.setAuthenticationManager(authenticationManager());
    	
    	return filter;
     }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(restAuthenticationEntryPoint)
		.and()
		.authorizeRequests()
		.antMatchers("/getAllUsers").hasRole("USER")
		.and()
		.authorizeRequests()
		.antMatchers("/getAll").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/register").permitAll()
		.and()
		.addFilterBefore(getUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		.logout()
		.logoutSuccessHandler(myLogoutSuccessHandler);
	}
}
