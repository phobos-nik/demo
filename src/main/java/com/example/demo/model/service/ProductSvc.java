package com.example.demo.model.service;

import com.example.demo.model.dao.entity.Product;
import com.example.demo.model.dto.request.CreateProductReq;
import com.example.demo.model.dto.response.ProductResp;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductSvc {

    Mono<Product> createGoods(String name,
                              String description);

    Mono<ProductResp> createGoods(CreateProductReq request);

    Flux<ProductResp> findAll();

    Mono<ProductResp> findById(UUID id);
}
