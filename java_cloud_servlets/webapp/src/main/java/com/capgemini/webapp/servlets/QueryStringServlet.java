package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryStringServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                 String name= req.getParameter("name");
                 String phone= req.getParameter("phone");
                 
                 PrintWriter out=resp.getWriter();
                 out.println("<html>");
                 out.println("<body>");
                 out.println("<h1>Name");
                 out.println(name);
                 out.println("</h1>");
                 
                 out.println("<h1>Phone");
                 out.println(phone);
                 out.println("</h1>");
                 out.println("</body>");
                 out.println("</html>");
	
	
	}

}
