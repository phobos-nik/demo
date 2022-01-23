package com.example.demo.model.service.impl;

import com.example.demo.model.dao.entity.Order;
import com.example.demo.model.dao.repository.OrderRep;
import com.example.demo.model.dao.repository.UserRep;
import com.example.demo.model.service.ProductSvc;
import com.example.demo.model.service.OrderSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderSvcImpl implements OrderSvc {

    private final UserRep userRep;
    private final OrderRep orderRep;
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final ProductSvc productSvc;

    @Override
    public Mono<Order> createOrder(UUID userId) {
        return reactiveMongoTemplate.insert(new Order(UUID.randomUUID(), userId));
    }

    @Override
    public Mono<Order> createOrder(UUID userId, Collection<UUID> productIds) {
        return Mono.empty();
    }

    @Override
    public Mono<Order> addProductsToOrder(UUID orderId, Collection<UUID> goodsIds) {
        return Mono.empty();
    }

    @Override
    public Mono<Order> removeProductsFromOrder(UUID orderId, Collection<UUID> goodsIds) {
        return Mono.empty();
    }
}
