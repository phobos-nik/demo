package com.example.demo.model.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "goods")
public class Goods {

    @Id
    private final UUID id;
    private final String name;
    private final String description;
}
