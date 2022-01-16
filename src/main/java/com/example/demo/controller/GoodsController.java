package com.example.demo.controller;

import com.example.demo.model.dto.request.CreateGoodsReq;
import com.example.demo.model.dto.response.GoodsResp;
import com.example.demo.model.service.GoodsSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsSvc goodsSvc;

    @PostMapping
    public Mono<GoodsResp> create(@RequestBody CreateGoodsReq request) {
        return goodsSvc.createGoods(request);
    }

    @GetMapping("/all")
    public Flux<GoodsResp> getAll() {
        return goodsSvc.findAll();
    }

    @GetMapping("{id}")
    public Mono<GoodsResp> get(@PathVariable("id") UUID id) {
        return goodsSvc.findById(id);
    }
}
