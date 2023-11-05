package com.example.mongocrud.component;

import com.example.mongocrud.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * @author Meenu Khurana
 * @created 06-10-2023
 */
class DataInitializerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private DataInitializer dataInitializer;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        dataInitializer = new DataInitializer(employeeRepository);
    }

    @Test
    void testRun() throws Exception {
        dataInitializer.run();
        verify(employeeRepository, times(1)).saveAll(any());
    }
}
