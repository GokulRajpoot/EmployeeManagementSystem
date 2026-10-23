
package com.ems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ems.model.Employee;

public class Main {

    private static final ArrayList<Employee> employees =
            new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

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
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println(
                            "Invalid choice. Please choose 1-9.");
            }

        } while (choice != 9);

        scanner.close();
    }

    private static void addEmployee() {

        System.out.println("\n--- Add Employee ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findEmployee(id) != null) {
            System.out.println(
                    "An employee with this ID already exists.");
            return;
        }

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter hire date (YYYY-MM-DD): ");
        LocalDate hireDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = new Employee(
                id,
                firstName,
                lastName,
                department,
                designation,
                hireDate,
                salary
        );

        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    private static void viewAllEmployees() {

        System.out.println("\n--- All Employees ---");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        displayEmployees(employees);
    }

    private static void findEmployeeById() {

        System.out.println("\n--- Find Employee ---");

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployee(id);

        if (employee != null) {
            employee.displayDetails();
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee() {

        System.out.println("\n--- Update Employee ---");

        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        System.out.print("Enter new designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter new hire date (YYYY-MM-DD): ");
        LocalDate hireDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setHireDate(hireDate);
        employee.setSalary(salary);

        System.out.println("Employee update operation completed.");
    }

    private static void deleteEmployee() {

        System.out.println("\n--- Delete Employee ---");

        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployee(id);

        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void sortEmployeesBySalary() {

        System.out.println("\n--- Employees Sorted By Salary ---");

        if (employees.isEmpty()) {
            System.out.println("No employees to sort.");
            return;
        }

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        displayEmployees(sortedEmployees);
    }

    private static void searchEmployeesByDepartment() {

        System.out.println("\n--- Search By Department ---");

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        List<Employee> matchingEmployees = employees.stream()
                .filter(employee -> employee.getDepartment()
                        .equalsIgnoreCase(department.trim()))
                .collect(Collectors.toList());

        if (matchingEmployees.isEmpty()) {
            System.out.println(
                    "No employees found in that department.");
        } else {
            displayEmployees(matchingEmployees);
        }
    }

    private static void displayEmployeeCount() {

        System.out.println(
                "Total employees: " + employees.size());
    }

    private static Employee findEmployee(int id) {

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }

        return null;
    }

    private static void displayEmployees(List<Employee> employeeList) {

        for (Employee employee : employeeList) {
            System.out.println("----------------------------");
            employee.displayDetails();
        }

        System.out.println("----------------------------");
    }
}
