package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResp {

    private String name;
    private String description;

    public static ProductResp of(Product product) {
        ProductResp productResp = new ProductResp();
        productResp.setName(product.getName());
        productResp.setDescription(product.getDescription());
        return productResp;
    }
}
