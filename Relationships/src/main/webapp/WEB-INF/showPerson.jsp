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
	<title>Person info page</title>
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
	<div class="container">
		<h1>Person Details:></h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>License Number</th>
					<th>State</th>
					<th>Exp Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${person.firstName}" /> <c:out
							value="${person.lastName}" /></td>
					<td><c:out value="${person.license.state}" /></td>
					<td><c:out value="${person}" /></td>
					<td><c:out value="${person.license.expirationDate}" /></td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>