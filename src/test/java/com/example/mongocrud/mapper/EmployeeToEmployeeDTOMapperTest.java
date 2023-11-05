package com.example.mongocrud.mapper;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Meenu Khurana
 * @created 06-10-2023
 */
class EmployeeToEmployeeDTOMapperTest {

    @Test
    void testCreateFrom() {

        final Employee employee = Employee.builder().id(1).name("Emp1").build();

        final EmployeeDTO employeeDTO = EmployeeToEmployeeDTOMapper.createFrom(employee);

        assertEquals(employeeDTO.getName(), employee.getName());
        assertEquals(employeeDTO.getId(), employee.getId());
    }
}
