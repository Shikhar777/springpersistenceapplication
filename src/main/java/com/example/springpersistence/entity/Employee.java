package com.example.springpersistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash(value = "FebEmployee")
@Getter
@Setter
public class Employee {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String departmentName;

}
