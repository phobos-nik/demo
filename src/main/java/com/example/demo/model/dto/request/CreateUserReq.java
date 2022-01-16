package com.example.demo.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserReq {

    @JsonProperty
    private String name;

    @JsonProperty
    private String surname;

    @JsonProperty
    private String middleName;
}
