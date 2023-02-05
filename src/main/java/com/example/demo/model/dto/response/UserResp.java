package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import reactor.core.publisher.Mono;

import java.util.UUID;

public record UserResp(@JsonProperty UUID id,
                       @JsonProperty String name,
                       @JsonProperty String surname,
                       @JsonProperty String middleName) {

    public static UserResp of(User user) {
        return new UserResp(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getMiddleName());
    }

    public static Mono<UserResp> of(Mono<User> user) {
        return user.map(UserResp::of);
    }
}
