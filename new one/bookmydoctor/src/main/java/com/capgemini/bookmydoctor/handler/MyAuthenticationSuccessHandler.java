package com.capgemini.bookmydoctor.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.capgemini.bookmydoctor.dto.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		UserResponse userResponse = new UserResponse();

		userResponse.setStatusCode(201);
		userResponse.setMessage("success");
		userResponse.setDescription("Login Successfull");

		ObjectMapper mapper = new ObjectMapper();

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().write(mapper.writeValueAsString(userResponse));
		response.setStatus(200);

	}

}
