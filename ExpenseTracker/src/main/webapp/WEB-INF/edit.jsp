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
	<title>Edit page</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex align-items-center justify-content-between">
			<h1>Edit Expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div>
			<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="name">Expense Name:</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" class="form-control" />
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor" class="text-danger"/>
					<form:input path="vendor" class="form-control" />
				</p>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:errors path="amount" class="text-danger"/>
					<form:input step="0.01" value="0.00" type="number" path="amount"
						class="form-control" />
				</p>
				<p>
					<form:label path="description">Description</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" class="form-control" />
				</p>
				<input type="submit" value="Submit" class="btn btn-info"/>
			</form:form>
		</div>
	</div>

</body>
</html>