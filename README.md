# Learner Management

A Spring Boot REST API for managing learners, secured with JWT authentication.

## Tech Stack

- Java 17, Spring Boot 4.1.1
- Spring Web MVC, Spring Data JPA (Hibernate), Bean Validation
- Spring Security with JWT (jjwt)
- Microsoft SQL Server
- springdoc-openapi (Swagger UI)
- Maven

## Prerequisites

- JDK 17+
- SQL Server running on `localhost:1433` with a database named `learner_management`

## Configuration

Database settings live in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=learner_management;encrypt=true;trustServerCertificate=true
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

Tables are created/updated automatically (`spring.jpa.hibernate.ddl-auto=update`).

## Run

```bash
./mvnw spring-boot:run
```

On Windows: `mvnw.cmd spring-boot:run`. The app starts on http://localhost:8080.

## API

| Method | Endpoint             | Description              |
|--------|----------------------|--------------------------|
| POST   | `/api/auth/login`    | Authenticate, receive JWT |
| POST   | `/api/learners`      | Create a learner         |
| GET    | `/api/learners`      | List learners            |
| GET    | `/api/learners/{id}` | Get a learner by id      |
| PUT    | `/api/learners/{id}` | Update a learner         |
| DELETE | `/api/learners/{id}` | Delete a learner         |

Learner endpoints require the header `Authorization: Bearer <token>`.

Interactive docs are available via Swagger UI at http://localhost:8080/swagger-ui.html.

## Test

```bash
./mvnw test
```

## Project Structure

```
src/main/java/com/example/learnermanagement
├── config        # Security and OpenAPI configuration
├── controller    # REST controllers
├── dto           # Request/response objects
├── entity        # JPA entities
├── exception     # Custom exceptions and global handler
├── repository    # Spring Data repositories
├── security      # JWT filter, service, entry point
└── service       # Business logic
```
