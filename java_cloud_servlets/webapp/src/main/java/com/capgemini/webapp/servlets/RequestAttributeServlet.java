package com.capgemini.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-attr")
public class RequestAttributeServlet extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         req.setAttribute("attr1", new Object());
         
         RequestDispatcher disp= req.getRequestDispatcher("/get-attr");
         disp.forward(req, resp);
     }
}
