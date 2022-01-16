package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResp {

    public static OrderResp of(Order order) {
        OrderResp orderResp = new OrderResp();
        return orderResp;
    }

    public static Mono<OrderResp> of(Mono<Order> order) {
        return order.map(OrderResp::of);
    }
}
