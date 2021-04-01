package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import org.springframework.stereotype.Component;

@Component
public class DtoToBasketMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<BasketDto, Basket> {
    @Override
    public Basket convert(BasketDto pojo) {

        Basket basket = new Basket();
        basket.setProducts(basket.getProducts());

        return basket;
    }
}
