package com.example.mongocrud.mapper;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Meenu Khurana
 * @created 06-10-2023
 */
class EmployeeDTOToEmployeeMapperTest {

    @Test
    void testCreateFrom() {

        final EmployeeDTO employeeDTO = EmployeeDTO.builder().id(1).name("Emp1").build();

        final Employee employee = EmployeeDTOToEmployeeMapper.createFrom(employeeDTO);

        assertEquals(employeeDTO.getId(), employee.getId());
        assertEquals(employeeDTO.getName(), employee.getName());
    }
}
