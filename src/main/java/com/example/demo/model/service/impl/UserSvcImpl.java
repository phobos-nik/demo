package com.example.demo.model.service.impl;

import com.example.demo.model.dao.entity.User;
import com.example.demo.model.dao.repository.UserRep;
import com.example.demo.model.dto.request.CreateUserReq;
import com.example.demo.model.service.UserSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserSvcImpl implements UserSvc {

    private final UserRep userRep;

    @Override
    public Mono<User> get(UUID id) {
        return userRep.findById(id);
    }

    @Override
    public Mono<User> create(CreateUserReq request) {
        User newUser = new User(
                UUID.randomUUID(),
                request.getName(),
                request.getSurname(),
                request.getMiddleName());
        return userRep.save(newUser);
    }
}
