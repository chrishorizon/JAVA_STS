<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

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
	<div class="container mt-4">
		<div class="d-flex align-items-center justify-content-between">
			<h4><c:out value="${langs.name}" /></h4>
			<a href="/languages" >Dashboard</a>
		</div>
		<div class="mt-3">
			<p><c:out value="${langs.creator}" /></p>
			<p><c:out value="${langs.version}" /></p>
			<div class="d-flex align-items-center">
				<a href="/languages/edit/${langs.id}">Edit</a>
				<form action="/languages/${langs.id}" method="post">
					<input type="hidden" name="_method" value="delete" />
					<input type="submit" value="Delete" class="btn btn-link"/>
				</form>
			</div>
		</div>
	</div>

</body>
</html>