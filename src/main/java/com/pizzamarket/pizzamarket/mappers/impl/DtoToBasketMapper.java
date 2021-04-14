package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToBasketMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<BasketDto, Basket> {

    @Autowired
    private DtoToProductMapper dtoToProductMapper;

    @Override
    public Basket convert(BasketDto pojo) {
        return new Basket(dtoToProductMapper.convertAll(pojo.getProducts()));
    }
}
