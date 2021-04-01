package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductToInputDtoMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<Product, InputProductDto> {
    @Override
    public InputProductDto convert(Product pojo) {
        return new InputProductDto(pojo.getId(),
                pojo.getCost(),
                pojo.getTitle(),
                pojo.getDescription(),
                pojo.getTag());
    }
}
