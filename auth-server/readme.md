

# Authentication Server Project with Spring Boot

This project is an authentication server implemented with Spring Boot. It provides endpoints for authentication token creation and support for user creation and management.

## Prerequisites

- Java JDK 17 or higher
- gradle

## Configuration

1. Clone this repository on your local machine.
2. Open the project in your preferred IDE.
3. Configure the database in `src/main/resources/application.properties`. You can use an embedded H2 database or any other Spring Boot compatible database.

## How to Run

1. Run the application from your IDE or using gradle with the command:
```bash
./gradlew :auth-server:bootRun
```

## Usage

The authentication server exposes the following endpoints:

- `http://localhost:8081/login/v1/`: Endpoint to authenticate and obtain an access token.
- `http://localhost:8081/user/v1/user/`: Endpoint to register a new user.

You can send HTTP requests to these endpoints using any HTTP client or tool such as cURL or Postman.

## Contributions

Contributions are welcome! If you encounter any problems or want to add new features, feel free to open an issue or send a pull request.
## Contact

If you have any questions or suggestions, you can contact the development team at[email](mailto:abjuancarlos.12@gmail.com) or [open an issue](https://github.com/JuanCarlosAguilarB/apigateway-with-auth-server-spring-boot).

