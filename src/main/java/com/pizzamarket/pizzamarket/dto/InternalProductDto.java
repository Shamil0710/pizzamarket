package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Дто для помещение в другие дто
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InternalProductDto {

    /**
     * id товара
     */
    @NotNull
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

    /**
     * Тег
     */
    private String tag;
}
