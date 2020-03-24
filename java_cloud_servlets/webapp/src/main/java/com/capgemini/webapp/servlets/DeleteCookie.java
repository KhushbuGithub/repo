package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-cookie")
public class DeleteCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("girl")) {
				cookie.setMaxAge(0);    //deleted cookie
				resp.addCookie(cookie);
			}

		}
		PrintWriter out = resp.getWriter();
		out.println("<html>" + "<body>" + "<h1>Cookie Deleted</h1>" + "</body>" + "</html>");
	}
}
