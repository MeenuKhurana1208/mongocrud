package com.example.mongocrud.controller;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;
import com.example.mongocrud.mapper.EmployeeDTOToEmployeeMapper;
import com.example.mongocrud.mapper.EmployeeToEmployeeDTOMapper;
import com.example.mongocrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class - works as entrypoint for the trading-application
 * @author Meenu Khurana
 * @created 05-10-2023
 */
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @DeleteMapping()
    @Operation(summary = "API to delete an employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> processemployee(@NotNull @RequestBody Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create new employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<EmployeeDTO>> createEmployees(@RequestBody @NotEmpty List<@Valid EmployeeDTO> employeeDTOList) {
        final List<Employee> employees = employeeService.createEmployees(employeeDTOList.stream().map(EmployeeDTOToEmployeeMapper::createFrom).toList());
        final List<EmployeeDTO> employeeDTOs = employees.stream().map(EmployeeToEmployeeDTOMapper::createFrom).toList();
        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get All Employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        final List<Employee> employees = employeeService.getEmployees();
        List<EmployeeDTO> employeeDTOList = employees.stream().map(EmployeeToEmployeeDTOMapper::createFrom).toList();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }
}
