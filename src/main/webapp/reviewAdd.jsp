<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ReviewAddServlet" method="post">
User Id: <input type="text" name="userId">
<input type="hidden" name="restaurantId" value="${param.restId}">
Rating: <input type="text" name="rating">
Title: <input type="text" name="title">
Review: <input type="text" name="review">
<!-- Review Id: <input type="text" name="reviewId"> -->

<input type="submit" value="Call Servlet" />
</form>
</body>
</html>	