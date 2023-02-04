<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/login.css">
<title>Restaurant review</title>
</head>
<body>
	<h2>SIGN IN</h2>
	<br>
	<div class="login">
		<form id="login" method="post" action="LoginServlet">
			<label><b>Username</b> </label> <input type="text" name="username" id="username" placeholder="Username" > <br>
			<br> <label><b>Password </b> </label> <input type="Password" name="password" id="password" placeholder="Password"> <br>
			<br> <input type="submit" name="login" id="Sign in" value="login" > <br>
			<br> <input type="checkbox" id="check"> <span>Remember me</span> <br>
			<br> <a href="#">Forgot Password</a> <br> <a href="Signup.jsp">Create account</a> <br> <a href="RestServlet/dashboard">HOME</a>
			
			<div id="message"></div>
		</form>
	</div>
</body>


</html>