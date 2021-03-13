package com.pizzamarket.pizzamarket.services.mappers.imp;

import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.services.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер сущности продукт в исходящее дто
 */
@Component
public class ProductToDtoMapper implements Mapper<Product, OutputProductDto> {

    @Override
    public OutputProductDto convert(Product pojo) {
        return new OutputProductDto(
                pojo.getId(),
                pojo.getCost(),
                pojo.getTitle(),
                pojo.getDescription(),
                pojo.getTag());
    }
}
