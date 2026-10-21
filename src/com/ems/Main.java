package com.ems;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Create employee objects using the constructor
        Employee emp1 = new Employee(101, "Rahul", "Rajpoot", "IT","Software_Intern" ,35000);
        Employee emp2 = new Employee(102, "Priya", "Rajpoot", "HR", "HR_Intern", 42000);

        // Display employee details through object methods
        System.out.println("\n--- First Employee ---");
        emp1.displayDetails();

        System.out.println("\n--- Second Employee ---");
        emp2.displayDetails();

        // Demonstrate getters and setters
        System.out.println("\n--- Encapsulation Test ---");

        emp1.setSalary(40000);
        emp1.setDepartment("Finance");

        System.out.println("Updated Salary: " + emp1.getSalary());
        System.out.println("Updated Department: " + emp1.getDepartment());
        
        // Demonstrate validation
        System.out.println("\n--- Validation Test ---");

        emp1.setSalary(-5000);
        emp1.setFirstName("");

        System.out.println("Salary: " + emp1.getSalary());
        System.out.println("Name: " + emp1.getFirstName());

        int choice = 0;
        
     // Menu system
        while (choice != 6) {
            displayMenu();

            if (sc.hasNextInt()) {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Add Employee selected.");
                        break;

                    case 2:
                        System.out.println("View All Employees selected.");
                        break;

                    case 3:
                        System.out.println("Find Employee By ID selected.");
                        break;

                    case 4:
                        System.out.println("Update Employee selected.");
                        break;

                    case 5:
                        System.out.println("Delete Employee selected.");
                        break;

                    case 6:
                        System.out.println(
                            "Exiting Employee Management System. Goodbye!");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice. Please select 1 to 6.");
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        sc.close();
    }

    // Method without parameters
    public static void displayWelcome() {
        System.out.println("===== EMPLOYEE MANAGEMENT SYSTEM =====");
        System.out.println("Welcome to Employee Management System!");
        System.out.println("Developed using Core Java");
    }

    // Reusable menu method
    public static void displayMenu() {
        System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Find Employee By ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}