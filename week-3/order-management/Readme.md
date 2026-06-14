# Order Management System

## Overview

Order Management System is a Spring Boot backend application that performs CRUD operations on customer orders using MySQL database integration.

## Features

* Create Order
* View All Orders
* View Order By ID
* Update Order
* Delete Order
* Pagination
* Sorting
* Validation Handling
* MySQL Database Integration

## Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman

## Database Configuration

Create database:

```sql
CREATE DATABASE orderdb;
```

Update application.properties with MySQL credentials.

## Running the Application

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

## API Endpoints

| Method | Endpoint     |
| ------ | ------------ |
| POST   | /orders      |
| GET    | /orders      |
| GET    | /orders/{id} |
| PUT    | /orders/{id} |
| DELETE | /orders/{id} |

