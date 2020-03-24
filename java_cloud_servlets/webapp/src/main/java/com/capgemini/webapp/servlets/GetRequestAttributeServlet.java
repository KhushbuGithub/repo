package com.capgemini.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-attr")
public class GetRequestAttributeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = req.getAttribute("attr1");

		PrintWriter out = resp.getWriter();
		out.println("<html>" + "<body><h1>");
		out.println(obj);
		out.println("</h1></body>" + "</html>");
	}
}
