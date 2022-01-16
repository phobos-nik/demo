package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResp {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String surname;

    @JsonProperty
    private String middleName;

    public static UserResp of(User user) {
        UserResp userResp = new UserResp();
        userResp.setId(user.getId());
        userResp.setName(user.getName());
        userResp.setSurname(user.getSurname());
        userResp.setMiddleName(user.getMiddleName());
        return userResp;
    }

    public static Mono<UserResp> of(Mono<User> user) {
        return user.map(UserResp::of);
    }
}
