<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="row">
<div class="container">

<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
</div>
<br>

<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li a:hover {
    background-color: #111;
}
</style>
<body>
    <ul>
        <li><a class="active" href="http://localhost:8090/restaurant_project/Login.jsp">Home</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="#about">About</a></li>
         <li><a href="#testing">Testing</a></li>

    </ul>

    <h3 class="text-center pt-3 pb-3">List of Restaurants</h3>

<div class="row">

<c:forEach var="rest" items="${listRests}">
  <div class="col-sm-4 pb-3">
    <div class="card">
      <div class="card-body">
      <img class="card-img-top" src= "<c:out value="${rest.image}" />" alt="Card image cap">
        <h5 class="card-title"><c:out value="${rest.title}" /></h5>
        <p class="card-text"><c:out value="${rest.description}" /></p>

<a href="details?restId=<c:out value='${rest.restId}' />">More Info</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/ReviewServlet?restId=<c:out value='${rest.restId}' />">Reviews</a> &nbsp;&nbsp;&nbsp;&nbsp;

      </div>
    </div>
  </div>
  </c:forEach>
</div>


</tbody>
</table>
</div>
</div>
</body>
</html>