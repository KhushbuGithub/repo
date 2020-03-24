package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:blue;'>");
		out.println(date);
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	

}
