package com.example.demo.model.dao.repository;

import com.example.demo.model.dao.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface UserRep extends ReactiveMongoRepository<User, UUID> {
}
