package com.example.demo.model.service.impl;

import com.example.demo.model.dao.entity.User;
import com.example.demo.model.dto.request.CreateUserReq;
import com.example.demo.model.service.UserSvc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class UserSvcImplTest {

    @Autowired
    private UserSvc userSvc;

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.7");

    @DynamicPropertySource
    static void setProps(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void save() {
        Mono<User> actual = userSvc.create(new CreateUserReq("name", "surname", "middleName"));
        StepVerifier
                .create(actual)
                .expectNextMatches(e ->
                        Objects.nonNull(e.getId()) &&
                        "name".equals(e.getName()) &&
                        "surname".equals(e.getSurname()) &&
                        "middleName".equals(e.getMiddleName()))
                .expectComplete()
                .verify();

    }


}