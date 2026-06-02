public class Employee {

    // Employee properties
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter method for employee ID
    public int getId() {
        return id;
    }

    // Getter method for employee name
    public String getName() {
        return name;
    }

    // Getter method for employee department
    public String getDepartment() {
        return department;
    }

    // Getter method for employee salary
    public double getSalary() {
        return salary;
    }

    // Displays employee details in readable format
    @Override
    public String toString() {

        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}