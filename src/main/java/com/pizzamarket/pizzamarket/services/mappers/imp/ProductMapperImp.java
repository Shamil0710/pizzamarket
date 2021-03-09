package com.pizzamarket.pizzamarket.services.mappers.imp;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.services.mappers.MapperDto;
import com.pizzamarket.pizzamarket.services.mappers.MapperEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImp implements MapperDto<OutputProductDto, Product>, MapperEntity<OutputProductDto, Product> {

    @Override
    public Product toEntity(InputProductDto inputProductDto) {
        Product product = new Product();

        product.setCost(inputProductDto.getCost());
        product.setDescription(inputProductDto.getDescription());
        product.setId(inputProductDto.getId());
        product.setTag(inputProductDto.getTag());
        product.setTitle(inputProductDto.getTitle());

        return  product;
    }

    @Override
    public OutputProductDto toDto(Product product) {
        return new OutputProductDto(product.getId(), product.getCost(), product.getTitle(), product.getDescription(), product.getTag());
    }
}
