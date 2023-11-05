package com.example.mongocrud.controller;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.dto.EmployeeDTO;
import com.example.mongocrud.mapper.EmployeeToEmployeeDTOMapper;
import com.example.mongocrud.service.EmployeeService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Meenu Khurana
 * @created 06-10-2023
 */
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void deleteEmployeeShouldReturnSuccess() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1);
        mockMvc.perform(delete("/api/v1/employees").content("1").contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getAllEmployees() throws Exception {
        final List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().id(1).name("emp1").build());
        employeeList.add(Employee.builder().id(2).name("emp2").build());
        employeeList.add(Employee.builder().id(3).name("emp3").build());

        Mockito.when(employeeService.getEmployees()).thenReturn(employeeList);
        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk());

    }

    @Test
    void createEmployeesShouldReturnSuccess() throws Exception {
        final List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().id(1).name("Emp1").build());
        employees.add(Employee.builder().id(2).name("Emp2").build());
        employees.add(Employee.builder().id(3).name("Emp3").build());

        final List<EmployeeDTO> employeeDTOList = employees.stream().map(EmployeeToEmployeeDTOMapper::createFrom).toList();
        final Gson gson = new Gson();
        final String employeesJsonArray = gson.toJson(employeeDTOList);

        Mockito.when(employeeService.createEmployees(employees)).thenReturn(employees);
        mockMvc.perform(post("/api/v1/employees").content(employeesJsonArray).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void createEmployeesShouldReturnBadRequestWhenEmployeeIdAndNameIsNull() throws Exception {
        final List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().build());

        final List<EmployeeDTO> employeeDTOList = employees.stream().map(EmployeeToEmployeeDTOMapper::createFrom).toList();
        final Gson gson = new Gson();
        final String employeesJsonArray = gson.toJson(employeeDTOList);

        mockMvc.perform(post("/api/v1/employees").content(employeesJsonArray).contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    void createEmployeesShouldReturnBadRequestWhenEmployeeNameIsNull() throws Exception {
        final List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().id(1).build());

        final List<EmployeeDTO> employeeDTOList = employees.stream().map(EmployeeToEmployeeDTOMapper::createFrom).toList();
        final Gson gson = new Gson();
        final String employeesJsonArray = gson.toJson(employeeDTOList);

        mockMvc.perform(post("/api/v1/employees").content(employeesJsonArray).contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}
