# Product Management REST API

## Overview

This project is a REST API built using Spring Boot for managing products. It follows a layered architecture and uses Spring Data JPA with MySQL for database operations.

## Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman

## Project Structure

```text
src/main/java/com/vishnu/productmanagementapi
│
├── controller
│   └── ProductController.java
│
├── service
│   └── ProductService.java
│
├── repository
│   └── ProductRepository.java
│
├── entity
│   └── Product.java
│
└── ProductManagementApiApplication.java
```

## Database Setup

Create a MySQL database:

```sql
CREATE DATABASE productdb;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application

Clone the repository and navigate to the project directory.

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## API Endpoints

### Create Product

```http
POST /products
```

Request Body:

```json
{
  "name": "Laptop",
  "price": 55000
}
```

### Get All Products

```http
GET /products
```

### Get Product By ID

```http
GET /products/{id}
```

### Update Product

```http
PUT /products/{id}
```

Request Body:

```json
{
  "name": "Gaming Laptop",
  "price": 70000
}
```

### Delete Product

```http
DELETE /products/{id}
```

## Features

* Create Product
* Retrieve All Products
* Retrieve Product By ID
* Update Product
* Delete Product
* MySQL Database Integration
* Layered Architecture
* RESTful API Design

## Testing

All APIs were tested successfully using Postman.
