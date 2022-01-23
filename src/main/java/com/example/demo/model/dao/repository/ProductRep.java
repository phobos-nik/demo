package com.example.demo.model.dao.repository;

import com.example.demo.model.dao.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface ProductRep extends ReactiveMongoRepository<Product, UUID> {

}
