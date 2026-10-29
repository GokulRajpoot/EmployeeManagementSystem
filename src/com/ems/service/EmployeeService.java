
package com.ems.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeRepository();
    }

    public boolean addEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null.");
        }

        if (repository.existsById(employee.getEmployeeId())) {
            return false;
        }

        repository.add(employee);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return repository.findById(employeeId);
    }

    public boolean updateEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException(
                    "Employee cannot be null.");
        }

        if (!repository.existsById(employee.getEmployeeId())) {
            return false;
        }

        return repository.update(employee);
    }

    public boolean deleteEmployee(int employeeId) {
        return repository.deleteById(employeeId);
    }

    public int getEmployeeCount() {
        return repository.count();
    }

    public List<Employee> getEmployeesSortedBySalary() {

        return repository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(
                        Employee::getSalary))
                .collect(Collectors.toList());
    }

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

