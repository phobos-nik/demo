package com.example.demo.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserReq (@JsonProperty String name,
                             @JsonProperty String surname,
                             @JsonProperty String middleName) {
}
