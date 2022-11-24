<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RestaurantServlet" method="post">
Rest Id: <input type="text" name="restId">
Image: <input type="text" name="image">
Description: <input type="text" name="description">
Address: <input type="text" name="address">
Contact: <input type="text" name="contact">
Website: <input type="text" name="website">
Title: <input type="text" name="title">

<input type="submit" value="Call Servlet" />
</form>
</body>
</html>