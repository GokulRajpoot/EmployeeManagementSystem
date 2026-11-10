
package com.ems.repository;

import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class InMemoryEmployeeRepository
        implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public Employee findById(int employeeId) {

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public boolean existsById(int employeeId) {
        return findById(employeeId) != null;
    }

    @Override
    public boolean update(Employee employee) {

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getEmployeeId()
                    == employee.getEmployeeId()) {

                employees.set(i, employee);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteById(int employeeId) {

        Employee employee = findById(employeeId);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    @Override
    public int count() {
        return employees.size();
    }
}
