package com.example.demo.model.dao.repository;

import com.example.demo.model.dao.entity.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface OrderRep extends ReactiveMongoRepository<Order, UUID> {
}
