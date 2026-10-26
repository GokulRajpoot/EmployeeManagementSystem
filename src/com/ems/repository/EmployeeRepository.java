
package com.ems.repository;

import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Employee findById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    public boolean existsById(int employeeId) {
        return findById(employeeId) != null;
    }

    public boolean update(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId()
                    == updatedEmployee.getEmployeeId()) {
                employees.set(i, updatedEmployee);
                return true;
            }
        }

        return false;
    }

    public boolean deleteById(int employeeId) {
        Employee employee = findById(employeeId);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    public int count() {
        return employees.size();
    }
}
