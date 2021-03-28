package com.pizzamarket.pizzamarket.dto;

import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import java.util.List;

/**
 * Дто для создание новой карзины
 */
public class InputBasketDto {

    /**
     * Пользователь
     */
    @NonNull
    private InternalUserDto user;

    /**
     * Перечень заказов
     */
    @Column
    private List<InputProductDto> products;
}
