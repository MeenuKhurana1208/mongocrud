package com.example.mongocrud.service;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service class to provide various operations for Employee
 * @author Meenu Khurana
 * @created 05-10-2023
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> createEmployees(final List<Employee> employeeList) {
        return employeeRepository.saveAll(employeeList);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Integer id) {
        employeeRepository.deleteById(id);
    }

}
