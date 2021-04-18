package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.stereotype.Component;


/**
 * Маппер входного дто в продук сущность
 */
@Component
public class DtoToProductMapper implements Mapper<InputProductDto, Product> {
    @Override
    public Product convert(InputProductDto pojo) {
        final Product product = new Product();

        product.setCost(pojo.getCost());
        product.setDescription(pojo.getDescription());
        product.setId(pojo.getId());
        product.setTag(pojo.getTag());
        product.setTitle(pojo.getTitle());

        return  product;
    }
}
