package com.Servlets;

import java.io.IOException;

import com.Servlets.dao.CreateAccountDao;
import com.java.CreateAccount;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (firstName == null || firstName.trim().isEmpty()
				|| lastName == null || lastName.trim().isEmpty()
				|| email == null || email.trim().isEmpty()
				|| password == null || password.trim().isEmpty()) {
			// Redirect to the login page
			response.sendRedirect("index.jsp");
			return;
		}
		CreateAccount account = new CreateAccount(firstName,lastName,email,password);

		CreateAccountDao createAccount = new CreateAccountDao();
		if(createAccount.create(account)) {
			response.sendRedirect("index.jsp");
		}
	}
}
