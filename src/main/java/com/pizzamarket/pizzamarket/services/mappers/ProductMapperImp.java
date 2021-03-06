package com.pizzamarket.pizzamarket.services.mappers;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;

public class ProductMapperImp implements ProductMapper {
    @Override
    public Product toProduct(InputProductDto inputProductDto) {
        Product product = new Product();

        product.setCost(inputProductDto.getCost());
        product.setDescription(inputProductDto.getDescription());
        product.setId(inputProductDto.getId());
        product.setTeg(inputProductDto.getTeg());
        product.setTitle(inputProductDto.getTitle());

        return  product;
    }

    @Override
    public OutputProductDto toDto(Product product) {
        return new OutputProductDto(product.getId(), product.getCost(), product.getTitle(), product.getDescription(), product.getTeg());
    }
}
