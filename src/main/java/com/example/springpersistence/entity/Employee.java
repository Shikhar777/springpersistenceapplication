package com.example.springpersistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "FebIntern")
@Getter
@Setter
public class Employee {

    @MongoId
    private long id;
    private String firstName;
    private String lastName;
    private String departmentName;

}
