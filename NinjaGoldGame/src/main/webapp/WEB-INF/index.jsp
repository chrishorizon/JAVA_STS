<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold Home Page</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	    <h1 class="mb-5 ml-5 mt-5">Your gold:  <c:out value="${gold}"/>  </h1>
    <div class="d-flex justify-content-between mb-5 ml-5 mr-5">
        
        <form class="bg-primary text-center border-secondary text-light p-5" action="/process_money" method="post">
            <h2>Farm</h2>
            <p>Earns 10-20 gold</p>
            <input type="hidden" name="building" value="farm" />
            <input type="submit" value="Find Gold!"/>
          </form>
     
        
        <form class="bg-primary text-center border-secondary text-light p-5" action="/process_money" method="post">
            <h2>Cave</h2>
            <p>Earns 5-10 gold</p>
            <input type="hidden" name="building" value="cave" />
            <input type="submit" value="Find Gold!"/>
          </form>
        <form class="bg-primary text-center border-secondary text-light p-5" action="/process_money" method="post">
            <h2>House</h2>
            <p>Earns 2-5 gold</p>
            <input type="hidden" name="building" value="house" />
            <input type="submit" value="Find Gold!"/>
          </form>
        <form class="bg-primary text-center border-secondary text-light p-5" action="/process_money" method="post">
            <h2>Casino</h2>
            <p>Lose 0-50 or Gain 0-50 </p>
            <input type="hidden" name="building" value="casino" />
            <input type="submit" value="Find Gold!"/>
          </form>
    </div>
    </div>

</body>
</html>