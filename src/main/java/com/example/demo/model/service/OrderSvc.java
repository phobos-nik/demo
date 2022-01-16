package com.example.demo.model.service;

import com.example.demo.model.dao.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface OrderSvc {

    Mono<Order> createOrder(UUID userId);

    Mono<Order> addGoodsToOrder(UUID orderId,
                                Flux<UUID> goodsIds);

    Mono<Order> removeGoodsFromOrder(UUID orderId,
                                     Flux<UUID> goodsIds);
}
