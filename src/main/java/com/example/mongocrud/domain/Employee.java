package com.example.mongocrud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Domain class for Employee entity
 * @author Meenu Khurana
 * @created 05-10-2023
 */
@Getter
@Builder
@Document(collection = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer id;
    private String name;
}
