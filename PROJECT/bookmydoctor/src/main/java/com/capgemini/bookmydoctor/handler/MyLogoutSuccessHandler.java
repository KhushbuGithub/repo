package com.capgemini.bookmydoctor.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.capgemini.bookmydoctor.dto.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws JsonProcessingException, IOException {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(201);
		userResponse.setMessage("success");
		userResponse.setDescription("you are succesfully logged out");

		response.setStatus(200);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(userResponse));
	}

}
