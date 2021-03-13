package com.pizzamarket.pizzamarket.dto;

import com.pizzamarket.pizzamarket.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Входящее дто для формирования заказов
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InputOrderDto {

    /**
     * id заказа
     */
    Long id;
    /**
     * Список товаров для создания заказа
     */
    List<Product> products;
}
