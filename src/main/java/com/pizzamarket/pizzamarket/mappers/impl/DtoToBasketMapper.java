package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Маппер преобразующий дто корзины в корзину
 */
@Component
public class DtoToBasketMapper implements Mapper<BasketDto, Basket> {

    @Autowired
    private DtoToProductMapper dtoToProductMapper;

    @Override
    public Basket convert(BasketDto pojo) {
        return new Basket(dtoToProductMapper.convertAll(pojo.getProducts()));
    }
}
