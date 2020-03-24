package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-con-attr")
public class AddContextAttribute extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 ServletContext context= getServletContext();
                 context.setAttribute("context-attr", new Object());
                 PrintWriter out= resp.getWriter();
                 out.println("<html><body>"
                 		+ "<h1>Context Object</h1>"
                 		+ "</body></html>");
	
	}

}
