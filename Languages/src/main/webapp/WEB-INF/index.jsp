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
	<div class="container">
		<div>
			<table class="table table-striped border border-2 text-center">
				<thead>
					<tr class="table-info">
						<th scope="col">Name</th>
						<th>Creator</th>
						<th>Version</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lang" items="${languages}">
						<tr>
							<td><a href="/languages/${lang.id}"><c:out value="${lang.name}" /></a></td>
							<td><c:out value="${lang.creator}" /></td>
							<td><c:out value="${lang.version}" /></td>
							<td>
								<div class="d-flex align-items-center">
									<a href="/languages/edit/${lang.id}">edit</a>
									<form action="/languages/${lang.id}" method="post">
										<input type="hidden" name="_method" value="delete" />
										<input type="submit" value="delete" class="btn btn-link"/>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Add Language</h3>
			<form:form action="/languages" method="post" modelAttribute="language">
				<p>
					<form:label path="name">Name:</form:label>
					<form:errors path="name" />
					<form:input path="name" class="form-control"/>
				</p>
				<p>
					<form:label path="creator">Creator:</form:label>
					<form:errors path="creator" />
					<form:input path="creator" class="form-control"/>
				</p>
				<p>
					<form:label path="version">Version:</form:label>
					<form:errors path="version" />
					<form:input path="version" class="form-control"/>
				</p>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
		
	</div>

</body>
</html>