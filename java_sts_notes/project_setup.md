1.	New -> Spring Starter Project
		Name: pascal case project name
		Type: Maven Project
		Packagin: War
		Java Version: 8
		Group: com.company.projectname (all lowercase)
		Description: project description
		Package: same as Group name

		Add Dependecies: Spring Web, Spring Boot DevTools, Spring JPA, MySQL Driver

2. Application Properties:
    src/main/resources -> application.properties
```java
    spring.mvc.view.prefix=/WEB-INF/
    // Data Persistence
    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA_NAME>>
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    // For Update and Delete method hidden inputs
    spring.mvc.hiddenmethod.filter.enabled=true
```

3. Create new schema in MySQL
		- same name as schema name in STS

4.	POM.xml:
		Add dependecies below:
```java
        <!-- DEPENDENCIES FOR STARTING SPRING PROJECTS-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- DEPENDENCIES FOR DISPLAYING JSPS AND USING JSTL TAGS -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <!-- DEPENDENCIES FOR INTEGRATING SQL DATABASE AND USING JPA -->
        <!-- Note: Project will not run until a schema has been created and the 
            proper settings in application properties are present for 
            connecting to a database. -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING VALIDATION ANNOTATIONS -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <!-- DEPENDENCY FOR USING BCRYPT  -->
        <dependency>
            <groupId>org.mindrot</groupId>
            <artifactId>jbcrypt</artifactId>
            <version>0.4</version>
        </dependency>
        <!-- DEPENDENCIES FOR BOOTSTRAP -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>webjars-locator</artifactId>
            <version>0.30</version>
        </dependency>
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

5. Create folders:
```java
    src/main/java ->
        com.horizon.projectname.models
        com.horizon.projectname.repositories
        com.horizon.projectname.services
        com.horizon.projectname.controllers
```

4. Models:
    Create inside package -> com.horizon.projectname.models
```java
		New class: Book (non-plural, pascal case)
		
		- add 2 annotations below
			@Entity
			@Table(name="books") (plural, javax imports)
		
		- Create full model file, structure below
			// ==== Primary Key =================
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
			// ==== Member Variables ============
			// ==== Data Creation Trackers ======
            @Column(updatable=false)
            @DateTimeFormat(pattern="yyyy-MM-dd")
            private Date createdAt;
            @DateTimeFormat(pattern="yyyy-MM-dd")
            private Date updatedAt;
			// ==== Constructors ================
            public Book() {}
            
			// ==== Data Creation Event =========
            @PrePersist
            protected void onCreate(){
                this.createdAt = new Date();
            }
            @PreUpdate
            protected void onUpdate(){
                this.updatedAt = new Date();
            }
			// ==== Getters and Setters =========
```

5. Repositories:
    Create inside package -> com.horizon.projectname.repositories
```java
		New interface: BookRepository (pascal case, non-plural)

		- add annotation above name:
			@Repository

		- add extends to the class name:
			extends CrudRepository<Book, Long>
				*Book is the model and Long is the type for the id

        - add functions:
        // this method retrieves all the books from the database
        List<Book> findAll();
```

6. Services:
    Create inside package -> com.horizon.projectname.services
```java
        New class: BookService (pascal case, non-plural)

		- add annotation below
			@Service
        
        - bring in book repository:
            option A)
            private final BookRepository repo;
            public BookService(BookRepository r){
                this.repo = r;
            }

            option B)
            @Autowired
            private BookRepository repo;

        - add crud methods
        // return all

        // retrive one

        // create

        // update one by ID

        // delete one by ID
```

7. Controllers:
    Create inside package -> com.horizon.projectname.controllers
```java
		- New class: BookController (pascal case)
		- add annotation below
			@Controller
        
        - add dependency injection to have access to our service
        @Autowired
        BookService serv;

        @GetMapping("/")
        public String index(){
            return "redirect:/dashboard";
        }

        - Create structure below
			// ==== Display =================

			// ==== Action ============
```

9. 	src -> main -> webapp: WEB-INF (new folder)
		- index.jsp (new jsp file)
			- change title to project name
			- add the below tag in index.jsp
```java
	<!-- c:out ; c:forEach etc. --> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- Formatting (dates) --> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- for rendering errors on PUT routes -->
    <%@ page isErrorPage="true" %>

	// Add this in the <head> for styling
	<!-- for CSS styling-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

    // JSTL will be used to insert values to display in the body of your html code
    - render information using JSTL tags
        <c:out value="${books}" />
```

