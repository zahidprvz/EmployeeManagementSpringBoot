# Employee Management System

![Java](https://img.shields.io/badge/Java-11-brightgreen)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.5-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.2-orange)
![JUnit](https://img.shields.io/badge/JUnit-5.8.0-yellow)

## Overview

The Employee Management System is a Spring Boot web application for managing employee records. It provides APIs to retrieve a list of employees, add new employees, and more.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Make sure you have the following tools installed:

- Java 11 or later
- Maven 3.8.2 or later

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/zpmughal/employee-management.git
   ```

2. Build the project:

   ```sh
   cd demo
   mvn clean install
   ```

## Usage

### Running the Application

Run the Spring Boot application using the following command:

```sh
mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

### API Endpoints

- **Get All Employees**: Retrieve a list of all employees.

  ```
  GET http://localhost:8080/employees/
  ```

- **Add Employee**: Add a new employee.

  ```
  POST http://localhost:8080/employees/
  ```

  Example Request Body:
  ```json
  {
    "first_name": "John",
    "last_name": "Doe",
    "email": "john@example.com",
    "title": "Manager"
  }
  ```

## Testing

To run the unit tests, use the following command:

```sh
mvn test
```

## Contributing

Contributions are welcome! Please open an issue or create a pull request if you would like to contribute to this project.

## License

This project is licensed under the [MIT License](LICENSE).
```
