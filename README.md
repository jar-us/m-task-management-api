# Task Management API

This is a Task Management API built with Spring Boot, Kotlin, and Gradle. It includes authentication and authorization
using Spring Security and JWT.

## Features

- **Task Management**: Create, update, delete, and retrieve tasks.
- **User Authentication**: Secure login and registration using JWT.
- **Role-Based Access Control**: Different functionalities for Admin and User roles.
- **Logging**: Detailed logging for web and security events.

## Getting Started

### Prerequisites

- Java 17
- Gradle
- PostgreSQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/jar-us/m-task-management-api.git
    cd task-management-api
    ```

2. Configure the database in `src/main/resources/application.properties`:
    ```ini
    spring.datasource.url=jdbc:postgresql://localhost:5432/task_management
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    ```

3. Build the project:
    ```sh
    ./gradlew build
    ```

4. Run the application:
    ```sh
    ./gradlew bootRun
    ```

### Usage

- Access the API at `http://localhost:8080`.
- Use a tool like Postman to interact with the API endpoints.

## API Endpoints

- `POST /api/auth/register`: Register a new user.
- `POST /api/auth/login`: Authenticate a user and receive a JWT.
- `GET /api/tasks`: Retrieve all tasks (Admin only).
- `POST /api/tasks`: Create a new task (Admin only).
- `PUT /api/tasks/{id}`: Update a task (Admin only).
- `DELETE /api/tasks/{id}`: Delete a task (Admin only).

## Logging

Logging is enabled for Spring Web and Security at the DEBUG level. You can adjust the logging levels in
`src/main/resources/application.properties`.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.