<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.java.GetUserDetails"%>
<%@ include file="logout.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
	text-align: center;
}

form {
	text-align: center;
}

.anchor-tag {
	text-align: right;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

session = request.getSession();

if (session.getAttribute("username") == null && session.getAttribute("userDetails") == null) {
	response.sendRedirect("index.jsp");
}
GetUserDetails details = (GetUserDetails) session.getAttribute("userDetails");
%>

<body bgcolor="cyan">
	<%
	if (details != null) {
	%>
	<h1>
		Welcome
		<%=details.getUser_Full_Name()%></h1>
	<br>
	<h2>Create your to do list here.</h2>

	<form action="task" method="post">
		<label for="task">Enter your tasks here : </label><input type="text"
			name="task" id="task"><br> <br> <input
			type="submit">
	</form>
	<%
	} else {
	%>
	<p>Failed to retrieve user details</p>
	<%
	}
	%>
	<br>
	<div class="anchor-tag">
		<a href="toDoList.jsp">check your to-do list here.</a>
	</div>
</body>
</html>
