package com.example.demo.model.service.impl;

import com.example.demo.model.dao.entity.Product;
import com.example.demo.model.dao.repository.ProductRep;
import com.example.demo.model.dto.request.CreateProductReq;
import com.example.demo.model.dto.response.ProductResp;
import com.example.demo.model.service.ProductSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductSvcImpl implements ProductSvc {

    private final ProductRep productRep;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Product> createGoods(String name,
                                     String description) {
        return productRep.save(
                new Product(
                        UUID.randomUUID(),
                        name,
                        description));
    }

    @Override
    public Mono<ProductResp> createGoods(CreateProductReq request) {
        return createGoods(
                request.getName(),
                request.getDescription())
                .map(ProductResp::of);
    }

    @Override
    public Flux<ProductResp> findAll() {
        return productRep.findAll()
                .map(ProductResp::of);
    }

    @Override
    public Mono<ProductResp> findById(UUID id) {
        return productRep.findById(id)
                .map(ProductResp::of);
    }
}
