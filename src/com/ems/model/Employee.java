
package com.ems.model;

import java.time.LocalDate;

public class Employee {

    // Private fields - Encapsulation
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private LocalDate hireDate;
    private double salary;

    // Constructor with validation
    public Employee(int employeeId, String firstName,
                    String lastName, String department,
                    String designation, LocalDate hireDate,
                    double salary) {

        if (employeeId <= 0) {
            throw new IllegalArgumentException(
                "Employee ID must be greater than zero.");
        }

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "First name cannot be empty.");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Last name cannot be empty.");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Department cannot be empty.");
        }

        if (designation == null || designation.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Designation cannot be empty.");
        }

        if (hireDate == null) {
            throw new IllegalArgumentException(
                "Hire date cannot be null.");
        }

        if (salary < 0) {
            throw new IllegalArgumentException(
                "Salary cannot be negative.");
        }

        this.employeeId = employeeId;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.department = department.trim();
        this.designation = designation.trim();
        this.hireDate = hireDate;
        this.salary = salary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName.trim();
        } else {
            System.out.println(
                "Invalid first name. It cannot be empty.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            System.out.println(
                "Invalid last name. It cannot be empty.");
        }
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department.trim();
        } else {
            System.out.println(
                "Invalid department. It cannot be empty.");
        }
    }

    public void setDesignation(String designation) {
        if (designation != null && !designation.trim().isEmpty()) {
            this.designation = designation.trim();
        } else {
            System.out.println(
                "Invalid designation. It cannot be empty.");
        }
    }

    public void setHireDate(LocalDate hireDate) {
        if (hireDate != null) {
            this.hireDate = hireDate;
        } else {
            System.out.println("Hire date cannot be null.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println(
                "Invalid salary. Salary cannot be negative.");
        }
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Salary: " + salary);
    }
}
