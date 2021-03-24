package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketToDto implements com.pizzamarket.pizzamarket.services.mappers.Mapper<Basket, BasketDto> {

    @Override
    public BasketDto convert(Basket pojo) {
        BasketDto basketDto = new BasketDto(pojo.getProducts());

        return basketDto;
    }
}
