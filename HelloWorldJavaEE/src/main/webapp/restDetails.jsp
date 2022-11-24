<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Rest Details Page</title>
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
<c:if test="${rest != null}">
<form action="getById" method="post"> //either method = "post" or method = "get"
</c:if>
<c:if test="${rest == null}">
<form action="insert" method="post"> //maybe can remove this part
</c:if>
<caption>
<h2>
<c:if test="${rest != null}">
Edit User
</c:if>
<c:if test="${rest == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${rest != null}">
<input type="hidden" rest="oriName" value="<c:out value='${rest.restId}' />" /> //rest can either be rest or name 
</c:if>

<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>