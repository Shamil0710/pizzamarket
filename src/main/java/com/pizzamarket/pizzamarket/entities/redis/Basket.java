package com.pizzamarket.pizzamarket.entities.redis;

import com.pizzamarket.pizzamarket.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * Сущность карзины для редиса
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Basket implements Serializable {

    /**
     * Список продуктов в корзине
     */
    private List<Product> products;
}
