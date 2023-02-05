package com.example.demo.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record CreateOrderReq (@JsonProperty UUID clientId,
                              @JsonProperty List<UUID> productIds) {
}
