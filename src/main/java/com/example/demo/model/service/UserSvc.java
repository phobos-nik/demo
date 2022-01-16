package com.example.demo.model.service;

import com.example.demo.model.dao.entity.User;
import com.example.demo.model.dto.request.CreateUserReq;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserSvc {
    Mono<User> get(UUID id);

    Mono<User> create(CreateUserReq request);
}
