package com.example.demo.model.service;

import com.example.demo.model.dao.entity.Order;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface OrderSvc {

    Mono<Order> createOrder(UUID userId);

    Mono<Order> createOrder(UUID userId,
                            Map<UUID, Integer> productCount);

    Mono<Order> addProductsToOrder(UUID orderId,
                                   Collection<UUID> goodsIds);

    Mono<Order> removeProductsFromOrder(UUID orderId,
                                        Collection<UUID> goodsIds);
}
