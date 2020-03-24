package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read-cookie")
public class ReadCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Cookie[] cookies=req.getCookies();
      PrintWriter out=resp.getWriter();
      out.println("<html>"
      		+ "<body>");
      for (Cookie cookie : cookies) {
		out.println("<h1>");
		out.println(cookie.getName());
		out.println(":");
		out.println(cookie.getValue());
		out.println("</h1>");
	}
	out.println("</body></html>");
	
	
	}

}
