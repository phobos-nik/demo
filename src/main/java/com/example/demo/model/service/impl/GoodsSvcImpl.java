package com.example.demo.model.service.impl;

import com.example.demo.model.dao.entity.Goods;
import com.example.demo.model.dao.repository.GoodsRep;
import com.example.demo.model.dto.request.CreateGoodsReq;
import com.example.demo.model.dto.response.GoodsResp;
import com.example.demo.model.service.GoodsSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GoodsSvcImpl implements GoodsSvc {

    private final GoodsRep goodsRep;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Goods> createGoods(String name,
                                   String description) {
        return goodsRep.save(
                new Goods(
                        UUID.randomUUID(),
                        name,
                        description));
    }

    @Override
    public Mono<GoodsResp> createGoods(CreateGoodsReq request) {
        return createGoods(
                request.getName(),
                request.getDescription())
                .map(GoodsResp::of);
    }

    @Override
    public Flux<GoodsResp> findAll() {
        return goodsRep.findAll()
                .map(GoodsResp::of);
    }

    @Override
    public Mono<GoodsResp> findById(UUID id) {
        return goodsRep.findById(id)
                .map(GoodsResp::of);
    }
}
