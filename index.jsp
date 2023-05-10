<html>
<head>
<style>
body {
	background-color: lightblue;
}

h1 {
	text-align: center;
	color: red;
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
</head>
<body>
	<h1>Welcome to To-do</h1>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<form action="login" method="post">
		<label for="user name">Enter username : </label> <input type="text"
			name="uname" id="user name" ><br> <br> <label
			for="password">Enter password : </label> <input type="password"
			name="pass" id="password"><br> <br> <input
			type="submit" value="Login">
		<div class="space"></div>
		<input type="reset">
	</form>
	<a style="display: block; text-align: center" href="createAccount.jsp">create
		account</a>
</body>
</html>
