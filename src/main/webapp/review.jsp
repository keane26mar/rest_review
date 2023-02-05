<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<div class="container text-left">
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
        <li><a class="active" href="RestServlet/dashboard">Home</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="#about">About</a></li>

    </ul>
    
    <h3 class="text-center">List of Reviews</h3>
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/reviewAdd.jsp?restId=<c:out value='${param.restId}' />"
					class="btn btn-success">Add New Review</a>
					
			</div>
			<br>
			<div class="row">
				<c:forEach var="review" items="${listReviews}">
					<div class="col-sm-4 pb-3">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">
								<u>
									<c:out value="${review.title}"/>
									</u>
								</h5>
								<p class="card-text">
									<c:out value="${review.review}" />
								</p>
								<p class="card-text">Rating :
									<c:out value="${review.rating}"/>
									</p>
									<a href="ReviewServlet/getById?reviewId=<c:out value="${review.reviewId}"/>&restId=${param.restId}">Edit Review</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>