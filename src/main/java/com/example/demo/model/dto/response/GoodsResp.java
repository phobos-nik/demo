package com.example.demo.model.dto.response;

import com.example.demo.model.dao.entity.Goods;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GoodsResp {

    private String name;
    private String description;

    public static GoodsResp of(Goods goods) {
        GoodsResp goodsResp = new GoodsResp();
        goodsResp.setName(goods.getName());
        goodsResp.setDescription(goods.getDescription());
        return goodsResp;
    }
}
