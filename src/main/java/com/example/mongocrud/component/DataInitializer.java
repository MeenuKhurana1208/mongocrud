package com.example.mongocrud.component;

import com.example.mongocrud.domain.Employee;
import com.example.mongocrud.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * @author Meenu Khurana
 * @created 05-10-2023
 * Data Initializer class to initialize mongo db collection at the time of start up of application
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    /**
     * This method reads json file from classpath resource and loads them into mongo collection
     *
     * @param args String argument
     */
    @Override
    public void run(String... args) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ClassPathResource resource = new ClassPathResource("data.json");
        final InputStream inputStream = resource.getInputStream();
        final List<Employee> dataItems = objectMapper.readValue(inputStream, new TypeReference<>() {
        });

        employeeRepository.saveAll(dataItems);
    }
}
