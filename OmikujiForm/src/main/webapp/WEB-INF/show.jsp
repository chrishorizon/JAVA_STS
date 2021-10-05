<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Info Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<h1>Here's Your Omikuji!</h1>
		<div class="row">
		<div class="col-4"></div>
			<div class="text-wrap col-4 bg-primary">
				In <c:out value="${number}"/> years, you will
				live in <c:out value="${city}"/> with <c:out value="${person}"/> 
				as your roommate, <c:out value="${hobby}"/> for a living. The
				next time you see a <c:out value="${thing}"/>, you will have good
				luck. Also, <c:out value="${message}"/>."
			</div>
		<div class="col-4"></div>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>