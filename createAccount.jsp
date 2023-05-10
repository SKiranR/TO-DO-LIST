<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
	text-align: center;
}

h2 {
	text-align: center;
}

form {
	text-align: center;
}

.space {
	width: 20px;
	height: auto;
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<body>
	<h1>Hello there!</h1>
	<h2>Create your account here.</h2>
	<form action="createAccount" method="post">
		<label for="firstname">Enter your name : </label> <input type="text"
			name="firstname" id="firstname"><br> <br> <label
			for="lastname">Enter your last name : </label> <input type="text"
			name="lastname" id="lastname"><br> <br> <label
			for="email">Enter your email-id : </label> <input type="text"
			name="email" id="email"><br> <br> <label
			for="password">Enter password : </label><input type="password"
			name="password" id="password"><br> <br> <input
			type="submit" value="Submit">
		<div class="space"></div>
		<input type="reset">

	</form>
</body>
</html>