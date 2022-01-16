package com.example.demo.model.service;

import com.example.demo.model.dao.entity.Goods;
import com.example.demo.model.dto.request.CreateGoodsReq;
import com.example.demo.model.dto.response.GoodsResp;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GoodsSvc {

    Mono<Goods> createGoods(String name,
                            String description);

    Mono<GoodsResp> createGoods(CreateGoodsReq request);

    Flux<GoodsResp> findAll();

    Mono<GoodsResp> findById(UUID id);
}
