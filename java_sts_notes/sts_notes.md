Spring Boot Structure is MVC - Models, View, Controller
    - the model in spring boot has 3 parts:
        1. Domain models, repositories, and surfaces
            Domain models are the data of our app, they structure how our tables and data are going to look like.
        2. Repositories are how we're going to query information from the database,
            creates the query
            - Our toolbox, gives us the tools to talk to the database
            - Crud functunality, extends CrudRepository
            - its an interface, interface is a collection of behaviours
        3. Services are the business logic of our application.
            its a way that our controllers will communicate with the database via the services.
            - the mechanic
            - services use tools from the repo to perform the crud actions
    
    - Controller:
        - talks to the client
        - Dealeship/ shop, the controller is the service writer
          receives HTTP request and sends HTTP responses.
        - a request has URL, method and a body