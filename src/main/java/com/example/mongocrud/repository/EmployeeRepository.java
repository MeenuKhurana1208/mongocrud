package com.example.mongocrud.repository;

import com.example.mongocrud.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Wrapper mongo db repository class to do CRUD operations on collection
 * @author Meenu Khurana
 * @created 05-10-2023
 */
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
}
