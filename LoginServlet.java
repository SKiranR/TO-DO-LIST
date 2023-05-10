package com.Servlets;

import java.io.IOException;

import com.Servlets.dao.LoginDao;
import com.java.GetUserDetails;
import com.java.Login;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {

		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		Login login = new Login(username,password);

		LoginDao logindao = new LoginDao();


		if(logindao.validate(login)) {
			GetUserDetails details = new GetUserDetails().getDetails(login);
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("userDetails", details);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}

	}
}
