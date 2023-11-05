package com.example.mongocrud.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


/**
 * DTO Class for request response
 * @author Meenu Khurana
 * @created 05-10-2023
 */
@Getter
@Builder
@AllArgsConstructor
public class EmployeeDTO {

    @NotNull(message = "Id can not be null")
    private Integer id;
    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    @Valid
    private String name;

}
