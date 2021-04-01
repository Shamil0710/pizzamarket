package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Дто для работы с корзиной
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {

    /**
     * Перечень товаров в корзине
     */
    private List<InputProductDto> products;

    /**
     * Номер телефона
     */
    private String phoneNumber;
}
