package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResp(@JsonProperty String name,
                          @JsonProperty String description) {

    public static ProductResp of(Product product) {
        return new ProductResp(product.getName(), product.getDescription());
    }
}
