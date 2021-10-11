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
	<title>Insert title here</title>
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
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja" >
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:errors path="dojo" class="text-danger" />
				<form:select path="dojo" class="form-control">
					<c:forEach var="oneDojo" items="${ dojos }">
						<form:option value="${ oneDojo.id }">
							<c:out value="${ oneDojo.name }" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName" class="text-danger" />
				<form:input path="firstName" class="form-control" />
			</p>
			<p>
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName" class="text-danger" />
				<form:input path="lastName" class="form-control" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" class="text-danger" />
				<form:input type="number" path="age" class="form-control" min="0" />
			</p>


			<input class="btn btn-primary mb-3" type="submit" value="Submit" />
		</form:form>
		<a href="/dojos/new">Dashboard</a>
		
	</div>
</body>
</html>