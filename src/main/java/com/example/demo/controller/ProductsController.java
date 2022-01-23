package com.example.demo.controller;

import com.example.demo.model.dto.request.CreateProductReq;
import com.example.demo.model.dto.response.ProductResp;
import com.example.demo.model.service.ProductSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController("/goods")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductSvc productSvc;

    @PostMapping
    public Mono<ProductResp> create(@RequestBody CreateProductReq request) {
        return productSvc.createGoods(request);
    }

    @GetMapping("/all")
    public Flux<ProductResp> getAll() {
        return productSvc.findAll();
    }

    @GetMapping("{id}")
    public Mono<ProductResp> get(@PathVariable("id") UUID id) {
        return productSvc.findById(id);
    }
}
