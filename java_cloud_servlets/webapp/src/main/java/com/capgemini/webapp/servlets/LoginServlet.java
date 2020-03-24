package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               String email=req.getParameter("email");
               String password = req.getParameter("password");
               
               PrintWriter out= resp.getWriter();
               out.println("<html><body>");
               
               if(email.equals("khush@gmail.com") && password.equals("7890")){
            	   HttpSession session = req.getSession(true);     //Creation of session
            	   session.setAttribute("sess-attr", new Object());
               out.println("<h1>Login Succesfull</h1>");
               }else {
            	   out.println("<h1>Invalid User</h1>");
               }
               out.println("</body></html>");
	}

}
