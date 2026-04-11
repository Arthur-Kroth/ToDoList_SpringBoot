<h1 align="center">
  TODO List
</h1>

A complete REST API for organizing and managing tasks, allowing you to create, list, update, and remove activities in a simple, efficient, and scalable way. Developed with best architectural practices and modern standards, the application facilitates daily task management and can be easily integrated with different frontend interfaces.
## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Practices adopted

- SOLID, DRY, YAGNI, KISS
- API REST
- Queries with Spring Data JPA
- Dependency Injection
- Error Handling
- Automatic Swagger Generation with OpenAPI 3

## How to Execute

- Clone the git repository
- Build the project:
```
$ ./mvnw clean package
```
- Run the application:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8081).
Swagger can be viewed at [localhost:8080/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## API Endpoints

To make the HTTP requests below, the following tool was used. [httpie](https://httpie.io):

- Create Task
```
$ http POST :8081/todos name="ToDo 1" description="Description Todo 1" completed=false priority=1

[
  {
    "completed": false,
    "description": "Description ToDo 1",
    "id": 1,
    "name": "ToDo 1",
    "priority": 1
  }
]
```

- Read Tasks
```
$ http GET :8081/todos

[
  {
    "completed": false,
    "description": "Description ToDo 1",
    "id": 1,
    "name": "ToDo 1",
    "priority": 1
  }
]
```

- Update Tasks
```
$ http PUT :8081/todos/1 name="ToDo 1" description="Big description ToDo 1" completed=true priority=1

[
  {
    "completed": true,
    "description": "Big description ToDo 1",
    "id": 1,
    "name": "ToDo 1",
    "priority": 1
  }
]
```

- Delete Tasks
```
http DELETE :8081/todos/1

[ ]
```
