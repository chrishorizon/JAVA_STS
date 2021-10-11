<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show dojo info</title>
	<!-- for CSS styling-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-2">
		<h1>
			<c:out value="${ dojo.name }" />
			Ninjas
		</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age Name</td>
				</tr>
				<c:forEach var="ninja" items="${ dojo.ninjas }">
					<tr>
						<td><c:out value="${ ninja.firstName }"></c:out></td>
						<td><c:out value="${ ninja.lastName }"></c:out></td>
						<td><c:out value="${ ninja.age }"></c:out></td>
					</tr>
				</c:forEach>
			</thead>
		</table>
		<a href="/dojos/new">Dashboard</a>
		
	</div>
</body>
</html>