<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/Signup.css">
<title>Signup</title>
</head>
<body>


<div class="container" id="registration">
				  <div class="title">Registration</div>
				  <div class="content">
					<form action="RegisterServlet" method="post">
					  <div class="user-details">
						<div class="input-box">
						 Name: <input type="text" name="username" id="username" placeholder="Enter your username" required="required" >
						</div>
						<div class="input-box">
			     		 Password: <input type="text" name="password" id="password" placeholder="Enter your password" required="required" >
						</div>
						<div class="input-box">
						 Email: <input type="text" name="email" id="email_address" placeholder="Enter your email" required="required">
						</div>
						<div class="input-box">
						 Mobile number: <input type="text" name="mobile_number" id="mobile_number" placeholder="Enter your number" required="required">
						</div>
					  </div>
					  
					  <div class="button">
						<input type="submit" value="Sign up"    href="Login.jsp">
						
						
					  </div>
		  <a href="index.jsp" style="float: right;">HOME</a>
			
					</form>
		

				  </div>
				</div>			  
			  </body>

			
          
        </form>
        

        <div id="message"></div>
</body>
</html>