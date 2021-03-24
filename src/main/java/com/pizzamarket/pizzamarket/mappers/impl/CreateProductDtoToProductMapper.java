package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.CreateProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import org.springframework.stereotype.Component;

/**
 * Дто для преобразование дто для создание нового товара в сущность
 */
@Component
public class CreateProductDtoToProductMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<CreateProductDto, Product> {

    @Override
    public Product convert(CreateProductDto pojo) {
        Product product = new Product();

        product.setCost(pojo.getCost());
        product.setDescription(pojo.getDescription());
        product.setTag(pojo.getTag());
        product.setTitle(pojo.getTitle());

        return product;
    }
}
