# Spring Boot REST API



## Project Overview
This is a Spring Boot REST API project using Gradle with Java 21.
 - check "Assignment Requirement" below for more details.

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

### Build the Project
```sh
gradle clean build
```

### Run the Application
```sh
gradle bootRun
```

The application will start at `http://localhost:8080`.

## Testing
Run tests with:
```sh
gradle test
```
Test logs will display passed, skipped, and failed tests.

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Test

## Contributing
Feel free to fork and submit pull requests.

## License
This project is open-source and available under the MIT License.



## Assignment Requirement

Application

We would like you to create a java-based backend application using REST.
It should contain the following endpoints.
• GET /api/interest-rates (get a list of current interest rates)
• POST /api/mortgage-check (post the parameters to calculate for a mortgage check)

The list of current mortgage rates should be created in memory on application startup.
The mortgage rate object contains the fields –
• maturityPeriod (integer),
• interestRate (Percentage) and
• lastUpdate (Timestamp)
The posted data for the mortgage check contains at least the fields;
• income (Amount),
• maturityPeriod (integer),
• loanValue (Amount),
• homeValue (Amount).
The mortgage check return if the mortgage is feasible (boolean) and the montly costs
(Amount) of the mortgage.

Business rules that apply are
- a mortgage should not exceed 4 times the income
- a mortgage should not exceed the home value

Use the frameworks as you see fit to build and test this.

Implementation
Treat this application as a real MVP that should go to production.

Duration
This assignment should take 4-5 hours at the most.


