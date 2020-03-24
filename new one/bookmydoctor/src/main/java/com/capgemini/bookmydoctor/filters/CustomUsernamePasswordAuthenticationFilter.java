package com.capgemini.bookmydoctor.filters;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.bookmydoctor.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private User userInfoBean;

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				User infoBean = getUserInfo(request);
				return infoBean.getPassword();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainPassword(request);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				User infoBean = getUserInfo(request);
				return infoBean.getEmail();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainUsername(request);
	}

	@SuppressWarnings("unused")
	private User getUserInfo(HttpServletRequest request) throws IOException {
		if (userInfoBean == null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = "";
			BufferedReader reader = request.getReader();
			while (reader.ready()) {
				json = json + reader.readLine();
			}
			userInfoBean = mapper.readValue(json, User.class);
		}
		return userInfoBean;

	}

}
