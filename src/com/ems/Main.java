package com.ems;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Display welcome message
        displayWelcome();

        // Demonstrate a method with a parameter
        displayEmployee("Rahul");
        displayEmployee("Priya");

        // Demonstrate a method with a return value
        double annualSalary = calculateAnnualSalary(35000);

        System.out.println("\n--- Salary Calculation ---");
        System.out.println("Monthly Salary: 35000");
        System.out.println("Annual Salary: " + annualSalary);

        // Create employee objects using the constructor
        Employee emp1 = new Employee(101, "Rahul", "Rajpoot", "IT","Software_Intern" ,35000);
        Employee emp2 = new Employee(102, "Priya", "Rajpoot", "HR", "HR_Intern", 42000);

        // Display employee details through object methods
        System.out.println("\n--- First Employee ---");
        emp1.displayDetails();

        System.out.println("\n--- Second Employee ---");
        emp2.displayDetails();

        // Repeating menu
        do {
            displayMenu();

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

        } while (choice != 6);

        sc.close();
    }

    // Method without parameters
    public static void displayWelcome() {
        System.out.println("===== EMPLOYEE MANAGEMENT SYSTEM =====");
        System.out.println("Welcome to Employee Management System!");
        System.out.println("Developed using Core Java");
    }

    // Method with one parameter
    public static void displayEmployee(String name) {
        System.out.println("Employee Name: " + name);
    }

    // Method with a return value
    public static double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }

    // Method with multiple parameters
    public static void displayEmployeeDetails(
            int employeeId, String name, String department) {

        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
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