package com.company.service;

import com.company.persistence.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public List<Employee> showAll();
    public Optional<Employee> findById(Integer id);
}
