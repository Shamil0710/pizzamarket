package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class InputProductDto {

    /**
     * ID продукта
     */
    private Long id;

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
    private String teg;
}
