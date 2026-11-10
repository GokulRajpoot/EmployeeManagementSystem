
package com.ems.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ems.exception.DuplicateEmployeeException;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.InMemoryEmployeeRepository;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new InMemoryEmployeeRepository();
    }

    // Add Employee
    public void addEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null.");
        }

        if (repository.existsById(employee.getEmployeeId())) {
            throw new DuplicateEmployeeException(
                    "Employee ID already exists: "
                            + employee.getEmployeeId());
        }

        repository.add(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Find Employee By ID
    public Employee getEmployeeById(int employeeId) {

        Employee employee = repository.findById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                    "Employee not found with ID: " + employeeId);
        }

        return employee;
    }

    // Update Employee
    public void updateEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null.");
        }

        if (!repository.update(employee)) {
            throw new EmployeeNotFoundException(
                    "Employee not found with ID: "
                            + employee.getEmployeeId());
        }
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        if (!repository.deleteById(employeeId)) {
            throw new EmployeeNotFoundException(
                    "Employee not found with ID: " + employeeId);
        }
    }

    // Get Employee Count
    public int getEmployeeCount() {
        return repository.count();
    }

    // Sort Employees By Salary
    public List<Employee> getEmployeesSortedBySalary() {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(
                        Employee::getSalary))
                .collect(Collectors.toList());
    }

    // Search Employees By Department
    public List<Employee> searchByDepartment(String department) {

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Department cannot be empty.");
        }

        return repository.findAll()
                .stream()
                .filter(employee -> employee.getDepartment()
                        .equalsIgnoreCase(department.trim()))
                .collect(Collectors.toList());
    }
}
