<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Restaurant Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Restaurant Details </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/RestServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">



      <img class="card-img-top" src= "<c:out value="${rest.image}" />" alt="Card image cap">

<h5 class="card-title">
									<c:out value="${rest.title}" />
								</h5>
									<p class="card-text">
									<c:out value="${rest.description}" />
								</p>
									<p class="card-text">
									<c:out value="${rest.contact}" />
								</p>
								
									<p class="card-text" >
									<c:out value="${rest.address}" />
								</p>
									<p class="card-text">
									<c:out value="${rest.website}" />
								</p>
								
</div>
</div>
</div>
</body>
</html>