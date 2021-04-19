package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * Дто для создания нового продукта
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

    /**
     * Стоимость товара
     */
    @NotNull
    private BigDecimal cost;

    /**
     * Название товара
     */
    @NotNull
    private String title;

    /**
     * Описание товара
     */
    private String description;

    /**
     * Тег помогающие группировать товары по разным категориям
     */
    private String tag;
}
