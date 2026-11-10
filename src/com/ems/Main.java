
package com.ems;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.ems.exception.DuplicateEmployeeException;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.util.InputUtil;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final InputUtil input =
            new InputUtil(scanner);

    private static final EmployeeService employeeService =
            new EmployeeService();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee By ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Sort Employees By Salary");
            System.out.println("7. Search Employees By Department");
            System.out.println("8. Display Employee Count");
            System.out.println("9. Exit");

            choice = input.readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewAllEmployees();
                        break;
                    case 3:
                        findEmployeeById();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        sortEmployeesBySalary();
                        break;
                    case 7:
                        searchEmployeesByDepartment();
                        break;
                    case 8:
                        displayEmployeeCount();
                        break;
                    case 9:
                        System.out.println("Thank you for using EMS!");
                        break;
                    default:
                        System.out.println("Invalid choice. Choose 1-9.");
                }

            } catch (DuplicateEmployeeException
                    | EmployeeNotFoundException
                    | IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 9);

        scanner.close();
    }

    // Add Employee
    private static void addEmployee() {

        System.out.println("\n--- Add Employee ---");

        int id = input.readInt("Enter employee ID: ");

        String firstName = input.readString("Enter first name: ");
        String lastName = input.readString("Enter last name: ");
        String department = input.readString("Enter department: ");
        String designation = input.readString("Enter designation: ");

        LocalDate hireDate = readHireDate();

        double salary = input.readDouble("Enter salary: ");

        Employee employee = new Employee(
                id, firstName, lastName,
                department, designation, hireDate, salary);

        employeeService.addEmployee(employee);

        System.out.println("Employee added successfully.");
    }

    // View All Employees
    private static void viewAllEmployees() {

        System.out.println("\n--- All Employees ---");

        List<Employee> employees =
                employeeService.getAllEmployees();

        displayEmployees(employees);
    }

    // Find Employee By ID
    private static void findEmployeeById() {

        System.out.println("\n--- Find Employee ---");

        int id = input.readInt("Enter employee ID: ");

        Employee employee =
                employeeService.getEmployeeById(id);

        employee.displayDetails();
    }

    // Update Employee
    private static void updateEmployee() {

        System.out.println("\n--- Update Employee ---");

        int id = input.readInt("Enter employee ID to update: ");

        Employee employee =
                employeeService.getEmployeeById(id);

        System.out.println("Enter new employee details:");

        String firstName = input.readString("Enter first name: ");
        String lastName = input.readString("Enter last name: ");
        String department = input.readString("Enter department: ");
        String designation = input.readString("Enter designation: ");

        LocalDate hireDate = readHireDate();

        double salary = input.readDouble("Enter salary: ");

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setHireDate(hireDate);
        employee.setSalary(salary);

        employeeService.updateEmployee(employee);

        System.out.println("Employee updated successfully.");
    }

    // Delete Employee
    private static void deleteEmployee() {

        System.out.println("\n--- Delete Employee ---");

        int id = input.readInt("Enter employee ID to delete: ");

        employeeService.deleteEmployee(id);

        System.out.println("Employee deleted successfully.");
    }

    // Sort Employees By Salary
    private static void sortEmployeesBySalary() {

        System.out.println("\n--- Employees Sorted By Salary ---");

        List<Employee> employees =
                employeeService.getEmployeesSortedBySalary();

        displayEmployees(employees);
    }

    // Search By Department
    private static void searchEmployeesByDepartment() {

        System.out.println("\n--- Search By Department ---");

        String department =
                input.readString("Enter department: ");

        List<Employee> employees =
                employeeService.searchByDepartment(department);

        displayEmployees(employees);
    }

    // Display Employee Count
    private static void displayEmployeeCount() {

        System.out.println(
                "Total employees: "
                        + employeeService.getEmployeeCount());
    }

    // Display Employee List
    private static void displayEmployees(List<Employee> employees) {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("----------------------------");
            employee.displayDetails();
        }

        System.out.println("----------------------------");
    }

    // Read and Validate Hire Date
    private static LocalDate readHireDate() {

        while (true) {

            String date = input.readString(
                    "Enter hire date (YYYY-MM-DD): ");

            try {
                return LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                System.out.println(
                        "Invalid date. Example: 2025-06-15");
            }
        }
    }
}
