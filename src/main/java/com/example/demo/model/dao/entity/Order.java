package com.example.demo.model.dao.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.UUID;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private final UUID id;
    private final UUID userId;
    private final Map<UUID, Integer> productIdCounts;
}
