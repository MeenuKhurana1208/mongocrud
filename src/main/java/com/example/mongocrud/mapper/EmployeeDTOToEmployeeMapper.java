package com.example.mongocrud.mapper;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;

/**
 * Mapper class to map StepDTO (sent in request) to Step POJO
 * @author Meenu Khurana
 * @created 05-10-2023
 */
public class EmployeeDTOToEmployeeMapper {

    private EmployeeDTOToEmployeeMapper() {
        throw new IllegalStateException("Can not instantiate mapper class");
    }
    public static Employee createFrom(final EmployeeDTO employeeDTO) {
        var employeeBuilder = Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName());
        return employeeBuilder.build();
    }
}
