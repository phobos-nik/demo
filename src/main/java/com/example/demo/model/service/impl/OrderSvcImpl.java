package com.example.demo.model.service.impl;

import com.example.demo.model.dao.consts.OrderDocFieldNames;
import com.example.demo.model.dao.entity.Order;
import com.example.demo.model.dao.repository.OrderRep;
import com.example.demo.model.dao.repository.UserRep;
import com.example.demo.model.service.OrderSvc;
import com.example.demo.model.service.ProductSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderSvcImpl implements OrderSvc {

    public static final FindAndModifyOptions RETURN_NEW_MODIFY_OPTIONS = FindAndModifyOptions.options().returnNew(true);
    public static final Criteria ID_CRITERIA = Criteria.where("id");

    private final UserRep userRep;
    private final OrderRep orderRep;
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final ProductSvc productSvc;

    @Override
    public Mono<Order> createOrder(UUID userId) {
        return reactiveMongoTemplate.insert(
                new Order(
                        UUID.randomUUID(),
                        userId,
                        Collections.emptyMap()));
    }

    @Override
    public Mono<Order> createOrder(UUID userId, Map<UUID, Integer> productCount) {
        return reactiveMongoTemplate.insert(
                new Order(
                        UUID.randomUUID(),
                        userId,
                        productCount));
    }

    @Override
    public Mono<Order> addProductsToOrder(UUID orderId, Collection<UUID> goodsIds) {
        return reactiveMongoTemplate.findAndModify(
                Query.query(ID_CRITERIA.is(orderId)),
                new Update().addToSet(OrderDocFieldNames.PRODUCT_IDS, goodsIds),
                RETURN_NEW_MODIFY_OPTIONS,
                Order.class);
    }

    @Override
    public Mono<Order> removeProductsFromOrder(UUID orderId, Collection<UUID> goodsIds) {
        return reactiveMongoTemplate.findAndModify(
                Query.query(ID_CRITERIA.is(orderId)),
                new Update()
                        .pull(
                                OrderDocFieldNames.PRODUCT_IDS,
                                Query.query(
                                        Criteria
                                                .where(OrderDocFieldNames.PRODUCT_IDS)
                                                .in(goodsIds))),
                RETURN_NEW_MODIFY_OPTIONS,
                Order.class);
    }
}
