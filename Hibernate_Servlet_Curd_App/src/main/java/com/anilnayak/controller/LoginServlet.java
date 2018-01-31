package com.anilnayak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anilnayak.pojo.User;
import com.anilnayak.service.LoginService;

public final class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     resp.setContentType("text/html;charset=UTF-8");
	     String userId = req.getParameter("userId");	
		 String password = req.getParameter("password");
		 LoginService loginService = new LoginService();
		 boolean result = loginService.authenticatedUser(userId, password);
		 User user = loginService.getUserByUserId(userId);
		 System.out.println("Result:::"+result);
		 if(result==true) {
			 req.getSession().setAttribute("user", user);
			 resp.sendRedirect("home.jsp");
		 }
		 else {
			resp.sendRedirect("error.jsp"); 
		 }
	}
	
	

}
