package com.example.mongocrud.repository;

import com.example.mongocrud.IntegrationTests;
import com.example.mongocrud.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Meenu Khurana
 * @created 06-10-2023
 */
class EmployeeRepositoryTest extends IntegrationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldReturnEmployeeForDefaultEmployee() {
        final Optional<Employee> employee = employeeRepository.findById(1);
        assertTrue(employee.isPresent());
    }

    @Test
    void whenEmployeeDoesNotExistInDbShouldReturnEmpty() {
        final Optional<Employee> employee = employeeRepository.findById(50);
        assertTrue(employee.isEmpty());
    }

    @Test
    void shouldSaveNewEmployees() {
        final List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().id(4).name("Emp4").build());
        employeeList.add(Employee.builder().id(5).name("Emp5").build());
        employeeList.add(Employee.builder().id(6).name("Emp6").build());

        employeeRepository.saveAll(employeeList);
        assertTrue(employeeRepository.findById(4).isPresent());
        assertTrue(employeeRepository.findById(5).isPresent());
        assertTrue(employeeRepository.findById(6).isPresent());
    }

    @Test
    void shouldFindAllEmployees() {
        final List<Employee> employeeList = employeeRepository.findAll();
        assertFalse(employeeList.isEmpty());
    }
}
