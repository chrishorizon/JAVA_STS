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
	<title>Create dojo page</title>
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
		<h1>New Dojo</h1>
		<form:form action="/dojos" method="post" modelAttribute="dojo" >
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" class="form-control" />
			</p>

			<input class="btn btn-info" type="submit" value="Submit" />
		</form:form>
		<div>
			<a href="/ninjas/new" class="btn btn-success mt-3" >Add Ninja</a>
		</div>
		<div class="mt-5">
			<h3>All Dojos</h3>
			<table>
				<thead>
					<tr>
						<th>Location Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dj}">
						<tr>
							<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>