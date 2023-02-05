package com.example.demo.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateProductReq (@JsonProperty String name,
                                @JsonProperty String description) {
}
