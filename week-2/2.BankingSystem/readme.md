JDBC Banking System
Overview

This project is a simple Banking System developed using Java, JDBC, and MySQL. It demonstrates database connectivity, CRUD operations, and transaction management using JDBC.


Technologies Used
Java
JDBC (Java Database Connectivity)
MySQL Database
VS Code
MySQL Connector/J


Features
Customer Management
Add Customer
View All Customers
Update Customer Details
Delete Customer
Transaction Management
Transfer money between customer accounts
Uses Commit and Rollback for data consistency


Project Structure
2.BankingSystem/
│
├── lib/
│   └── mysql-connector-j-8.4.0.jar
│
├── src/
│   ├── DBConnection.java
│   ├── ConnectionTest.java
│   ├── Customer.java
│   ├── CustomerDAO.java
│   └── BankingSystem.java
│
└── README.md


Database Structure
Database
banking_db
Customers Table
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    balance DECIMAL(10,2) DEFAULT 0.00
);

How to Run
1.Install MySQL Server.
2.Create the banking_db database.
3.Create the customers table.
4.Add MySQL Connector/J JAR to the project.
5.Update database credentials in DBConnection.java.
6.Run BankingSystem.java.