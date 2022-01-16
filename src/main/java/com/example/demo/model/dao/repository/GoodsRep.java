package com.example.demo.model.dao.repository;

import com.example.demo.model.dao.entity.Goods;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface GoodsRep extends ReactiveMongoRepository<Goods, UUID> {

}
