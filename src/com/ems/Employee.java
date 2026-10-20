package com.ems;

public class Employee {

    // Instance variables
    int employeeId;
    String name;
    String department;
    double salary;

    // Constructor
    public Employee(int employeeId, String name,
                    String department, double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}