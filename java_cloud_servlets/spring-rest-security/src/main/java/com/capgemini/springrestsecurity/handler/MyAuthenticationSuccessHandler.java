package com.capgemini.springrestsecurity.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.capgemini.springrestsecurity.beans.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(201);
		userResponse.setMessage("Success");
		userResponse.setDescription("Login Successfull");

		response.setStatus(200);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(userResponse));
		
//		String json= mapper.writeValueAsString(userResponse);
//		PrintWriter out= response.getWriter();
//		out.write(json);

	}

}
