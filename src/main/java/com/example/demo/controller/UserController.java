package com.example.demo.controller;

import com.example.demo.model.dto.request.CreateUserReq;
import com.example.demo.model.dto.response.UserResp;
import com.example.demo.model.service.UserSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSvc userSvc;

    @PostMapping
    public Mono<UserResp> create(@RequestBody CreateUserReq request) {
        return UserResp.of(userSvc.create(request));
    }

    @GetMapping("/{id}")
    public Mono<UserResp> get(@PathVariable("id") UUID id) {
        return UserResp.of(userSvc.get(id));
    }
}
