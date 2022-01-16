package com.example.demo.model.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "users")
public class User {

    @Id
    private final UUID id;
    private final String name;
    private final String surname;
    private final String middleName;

}
