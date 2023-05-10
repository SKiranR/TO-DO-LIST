package com.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Servlets.dao.Dao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddTaskServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String query = "insert into tasks(username,task) values(?,?)";
	String username;
	String getTask;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("username");
		getTask = request.getParameter("task");
		if(getTask.isEmpty()) {
			response.sendRedirect("welcome.jsp");
			return;
		}
		try {
			Connection conn = Dao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, getTask);
			statement.executeUpdate();
			response.sendRedirect("welcome.jsp");
			statement.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
