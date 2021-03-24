package com.pizzamarket.pizzamarket.dto;

import com.pizzamarket.pizzamarket.entities.Product;
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

    //TODO стоит ли сюда добавить номер телефона?
    /**
     * Перечень товаров в корзине
     */
    private List<Product> products;
}
