package com.pizzamarket.pizzamarket.services.mappers;

import com.pizzamarket.pizzamarket.dto.InputProductDto;
import com.pizzamarket.pizzamarket.dto.OutputProductDto;
import com.pizzamarket.pizzamarket.entities.Product;

public interface ProductMapper {

    /**
     * Метод преобразование сущности в дто
     * @param inputProductDto
     * @return
     */
    Product toProduct(InputProductDto inputProductDto);

    /**
     * Метод преобразование дто в сущность
     * @param product
     * @return
     */
    OutputProductDto toDto(Product product);


}
