<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Restaurant Details </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/RestServlet"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${rest != null}">
<form action="getById" method="post"> 
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
<input type="hidden" name="restId" value="<c:out value='${rest.restId}' />" /> 
</c:if>

 

 
   <c:out value="${rest.title}" />
 


</form>
</div>
</div>
</div>

</body>
</html>