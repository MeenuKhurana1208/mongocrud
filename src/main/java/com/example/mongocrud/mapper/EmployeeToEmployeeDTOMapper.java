package com.example.mongocrud.mapper;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;

/**
 * Mapper class to map StepDTO (sent in request) to Step POJO
 * @author Meenu Khurana
 * @created 05-10-2023
 */
public class EmployeeToEmployeeDTOMapper {

    private EmployeeToEmployeeDTOMapper() {
        throw new IllegalStateException("Can not instantiate mapper class");
    }
    public static EmployeeDTO createFrom(final Employee employee) {
        var employeeDTOBuilder = EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName());
        return employeeDTOBuilder.build();
    }
}
