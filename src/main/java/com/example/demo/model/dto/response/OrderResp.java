package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

public record OrderResp(@JsonProperty UUID id,
                        @JsonProperty UUID userId,
                        @JsonProperty Map<UUID, Integer> productIds) {

    public static OrderResp of(Order order) {
        return new OrderResp(order.getId(), order.getUserId(), order.getProductIdCounts());
    }

    public static Mono<OrderResp> of(Mono<Order> order) {
        return order.map(OrderResp::of);
    }
}
