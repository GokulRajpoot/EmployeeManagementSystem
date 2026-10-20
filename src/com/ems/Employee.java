package com.ems;

public class Employee {

    // Instance variables
    int employeeId;
    String firstName;
    String lastName;
    String department;
    String designation;
    double salary;

    // Constructor
    public Employee(int employeeId, String firstName, String lastName, String department, String designation,
			double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
	}

    // Display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }

}