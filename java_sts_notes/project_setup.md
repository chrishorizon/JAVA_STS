1.	New -> Spring Starter Project
		Name: pascal case project name
		Type: Maven Project
		Packagin: War
		Java Version: 8
		Group: com.company.projectname (all lowercase)
		Description: project description
		Package: same as Group name

		Add Dependecies: Spring Web

2.	POM.xml:
		Dependecies -> Add:
			tomcat-embed-jasper
			jstl - javax.servlet
		Optional: BOOTSTRAP
```java
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>webjars-locator</artifactId>
			<version>0.30</version>
		</dependency>
		<!-- BOOTSTRAP DEPENDENCIES -->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>5.0.1</version>
		</dependency>
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.6.0</version>
		</dependency>
```

3.	src/main/resources -> application.properties
```java
		spring.mvc.view.prefix=/WEB-INF/
```

4.	src/main/java -> new package: com.horizon.projectname.controllers
		- new -> class: ProjectNameController (pascal case)
		- add @Controller above public class

5. 	src -> main -> webapp: WEB-INF (new folder)
		- index.jsp (new jsp file)
			- change title to project name
			- add the below tag in index.jsp
```java
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	// Add this in the <head> for styling
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
```

6. src/main/java -> new package: com.horizon.projectname.models

7. Create new class in models folder (pascal case)