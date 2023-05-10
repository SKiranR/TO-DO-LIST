<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="logout.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.Servlets.dao.GetTaskDao"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	session = request.getSession();

	if (session.getAttribute("username") == null && session.getAttribute("userDetails") == null) {
		response.sendRedirect("index.jsp");
	}

	String username = (String) session.getAttribute("username");
	GetTaskDao task = new GetTaskDao();
	ResultSet set = task.getTask(username);
	%>
	<%
	if (set != null) {
	%>
	<h2>Your tasks are here Mr. ${username}</h2>
	<form action="deleteTask" method="post">
		<%
		while (set.next()) {
			String tasks = set.getString("task");
			int id = set.getInt("id");
			out.println("<input type=\"radio\" name=\"selectedIds\" value=\"" + id + "\" >");
			out.println("<label>" + tasks + "</label><br><br>");
		}
		set.close();
		%>
		<input type="submit" value="Delete"><br><br>
		<label>You can delete only one task at time</label>
	</form>
	<%
	} else {
	%>
	<h1>null/no tasks here.</h1>
	<%
	}
	%>
</body>
</html>