package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp =req.getRequestDispatcher("/first");
		disp.include(req, resp);
		PrintWriter out=resp.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<h1>This is include Servlet</h1>"
				+ "</body>"
				+ "</html>");
	}

}
