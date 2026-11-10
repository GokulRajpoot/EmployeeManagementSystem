
package com.ems.repository;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeRepository {

    void add(Employee employee);

    List<Employee> findAll();

    Employee findById(int employeeId);

    boolean existsById(int employeeId);

    boolean update(Employee employee);

    boolean deleteById(int employeeId);

    int count();
}
