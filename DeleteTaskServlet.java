package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.Servlets.dao.DeleteTaskDao;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteTaskServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String taskId = request.getParameter("selectedIds");
		if(taskId == null) {
			response.sendRedirect("toDoList.jsp");
			return;
		}
		
		DeleteTaskDao delTask = new DeleteTaskDao();
		boolean success = delTask.delete(Integer.parseInt(taskId));
		if(success) {
			response.sendRedirect("toDoList.jsp");
		}else {
			out.println("Could not delete task");
		}
	}
}
