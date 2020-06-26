package com.capgemini.javacloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.javacloud.filters.CustomUsernamePasswordAuthenticationFilter;
import com.capgemini.javacloud.handler.MyLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BootAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private MyLogoutSuccessHandler myLogoutSuccessHandler;

	@Bean
	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}

	@Bean
	public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter() throws Exception {
		CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
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
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
        .authorizeRequests()
		.antMatchers("/template/register-user").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/login").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/view-allusers").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/search-ratingandreview/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/get-ratingbyname/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/add-patient/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/view-appiontment/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/get-appiontment/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/get-appiontmentbyname/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/delete-user/**").hasRole("ADMIN")
		.and()
        .authorizeRequests()
		.antMatchers("/template/view-patient/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/view-allpatients").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/delete-patient/{patientId}").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/modify-Patient").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/add-doctor/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/delete-doctor/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/get-alldoctors").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/search-doctorCity/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/modify-doctor").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/template/view-doctor/**").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/add-appiontment").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/template/view-allappiontment").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/template/delete-appiontment/**").hasRole("PATIENT")
		.and()
		.authorizeRequests()
		.antMatchers("/template/modify-Appiontment").hasRole("PATIENT")
		.and()
		.addFilterBefore(getUsernamePasswordAuthenticationFilter(),
						CustomUsernamePasswordAuthenticationFilter.class)
		.logout().logoutSuccessHandler(myLogoutSuccessHandler)
		.and()
		.cors();

	}
}
