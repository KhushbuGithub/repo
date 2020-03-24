package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email= req.getParameter("email");
        String pass= req.getParameter("password");
        String mobno= req.getParameter("mobno");
	
	    PrintWriter out= resp.getWriter();
	    out.println("<html>");
	    out.println("<body>");
	    out.println("<h1>");
	    out.println("Name:"+ name);
	    out.println("</h1>");
	    
	    out.println("<h1>");
	    out.println("Email:"+ email);
	    out.println("</h1>");
	    
	    out.println("<h1>");
	    out.println("Password:" +pass);
	    out.println("</h1>");
	    
	    out.println("<h1>");
	    out.println("Mobile:"+mobno);
	    out.println("</h1>");
	    
	    out.println("</body>");
	    out.println("</html>");
	}

}
