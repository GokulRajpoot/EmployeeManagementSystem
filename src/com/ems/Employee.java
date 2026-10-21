package com.ems;

public class Employee {

    // Instance variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private double salary;

    // Constructor
    public Employee(int employeeId, String firstName, String lastName, String department, String designation,
			double salary) {
    	
    	if (employeeId > 0) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException(
                "Employee ID must be greater than zero.");
        }
    	
    	if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException(
                "Employee name cannot be empty.");
        }
		
    	this.lastName = lastName;
    	
    	if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            throw new IllegalArgumentException(
                "Department cannot be empty.");
        }
    	
    	if (designation != null && !designation.trim().isEmpty()) {
            this.designation = designation;
        } else {
            throw new IllegalArgumentException(
                "Department cannot be empty.");
        }
    	
    	if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException(
                "Salary cannot be negative.");
        }
	}
    
    //Getters
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
    
    public double getSalary() {
        return salary;
    }
    
    //setters
    public void setFirstName(String firstName) {
    	if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        } else {
        	 System.out.println(
                     "Invalid name. Name cannot be empty.");
        }
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setDepartment(String department) {
        if (department != null &&
            !department.trim().isEmpty()) {
            this.department = department;
        } else {
            System.out.println(
                "Invalid department. Department cannot be empty.");
        }
    }

    public void setDesignation(String designation) {
    	if (designation != null && !designation.trim().isEmpty()) {
            this.designation = designation;
        } else {
        	System.out.println(
                    "Invalid designation. Designation cannot be empty.");
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
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }

}