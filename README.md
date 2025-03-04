# Spring Boot REST API

## Project Overview
This is a Spring Boot REST API project using Gradle with Java 21.
- Check [Assignment Requirement](#assignment-requirement) below for more details.

## Prerequisites
- Java 21
- Gradle
- Spring Boot 3.2.0+
- Maven Central repository access

## Project Setup

### Clone the Repository
```sh
git clone git@github.com:krunalsabnis/demo-mortgage-rest-springboot.git
cd demo-mortgage-rest-springboot
```


## Quick Test with docker ?
- Please check [Docker](#docker) below to build and bring the application up as described in the [Application URL](#application-url) section below.


## Build Setup
- If you are using IntelliJ IDEA, you can import the project directly by opening the `build.gradle` file.
- You can either build or run using docker compose or gradle commands.
- Use docker compose - If you do not want to install / change Java version to test this project. You only need docker-compose and docker on the host machine.

### Build the Project
```sh
gradlew clean build
```

## Testing
Run tests with:
```sh
gradle test
```

### Run the Application
```sh
gradlew bootRun
```

### Docker

Use docker compose - If you do not want to install / change Java version to test this project.
You only need docker-compose and docker on the host machine

```sh
  docker-compose up --build
```

Docker image can be created using the following command in project root directory

```sh
  docker build -t demo:1.0 .
  docker run -p 8080:8080 demo:1.0
```


## Application URL
🔗 The application will start at
👉 http://localhost:8080

🔗 Swagger UI URL:
👉 http://localhost:8080/swagger-ui.html

📄 OpenAPI JSON (for API clients):
👉 http://localhost:8080/v3/api-docs


Test logs will display passed, skipped, and failed tests.

🔗 Swagger UI URL:
👉 http://localhost:8080/swagger-ui.html

📄 OpenAPI JSON (for API clients):
👉 http://localhost:8080/v3/api-docs




## Assignment Requirement

### Application
We would like you to create a java-based backend application using REST.
It should contain the following endpoints.
- **GET** `/api/interest-rates` (get a list of current interest rates)
- **POST** `/api/mortgage-check` (post the parameters to calculate for a mortgage check)

The list of current mortgage rates should be created in memory on application startup.
The mortgage rate object contains the fields:
- `maturityPeriod` (integer)
- `interestRate` (Percentage)
- `lastUpdate` (Timestamp)

The posted data for the mortgage check contains at least the fields:
- `income` (Amount)
- `maturityPeriod` (integer)
- `loanValue` (Amount)
- `homeValue` (Amount)

The mortgage check returns whether the mortgage is feasible (`boolean`) and the monthly cost (`Amount`) of the mortgage.

### Business Rules
- A mortgage should not exceed **4 times** the income.
- A mortgage should not exceed **the home value**.

### Implementation
Treat this application as a real MVP that should go to production.

### Duration
This assignment should take **4-5 hours at the most**.