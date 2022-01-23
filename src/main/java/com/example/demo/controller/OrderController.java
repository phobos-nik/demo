package com.example.demo.controller;

import com.example.demo.model.dto.request.CreateOrderReq;
import com.example.demo.model.dto.response.OrderResp;
import com.example.demo.model.service.OrderSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;

@RestController("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderSvc orderSvc;

    @GetMapping
    public Mono<OrderResp> create(@RequestParam("user_id") UUID userId) {
        return OrderResp.of(orderSvc.createOrder(userId));
    }

    @GetMapping
    public Mono<OrderResp> create(@RequestParam("user_id") UUID userId,
                                  @RequestParam(value = "products_ids", required = false) Collection<UUID> productIds) {
        return OrderResp.of(orderSvc.createOrder(userId, productIds));
    }

    @PostMapping
    public Mono<OrderResp> create(@RequestBody CreateOrderReq request) {
        return Mono.empty();
    }
}
