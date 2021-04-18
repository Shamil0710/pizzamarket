package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.stereotype.Component;


/**
 * Преобразование из сущности в дто продукта
 */
@Component
public class ProductToInputDtoMapper implements Mapper<Product, InputProductDto> {
    @Override
    public InputProductDto convert(Product pojo) {
        return new InputProductDto(pojo.getId(),
                pojo.getCost(),
                pojo.getTitle(),
                pojo.getDescription(),
                pojo.getTag());
    }
}
