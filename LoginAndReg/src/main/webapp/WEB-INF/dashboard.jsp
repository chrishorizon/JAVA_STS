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
	<title>Dashboard Home Page</title>
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
	<div class="container mt-3">
		<div class="d-flex align-items-center justify-content-between">
			<h1>Welcome, <c:out value="${loggedInUser.userName}" /></h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+Add a book to my shelf</a>
		</div>
		<div>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bk" items="${allBooks}">
						<tr>
							<td><c:out value="${bk.id}"/></td>
							<td><a href="/books/${bk.id}"><c:out value="${bk.title}"/></a></td>
							<td><c:out value="${bk.author}" /></td>
							<td><c:out value="${bk.creator.userName}" /></td>
							<td>
								<c:if test="${loggedInUser.id == bk.creator.id }" >
									<form action="/books/${bk.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete" />
										<input type="submit" value="Delete" class="btn btn-link" />
									</form>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	</div>
</body>
</html>