package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


/**
 * Исходящее дто заказа
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OutputOrderDto {

    /**
     * ID заказа
     */
    @NotNull
    private Long id;

    /**
     * Пользователь которому пренадлежить заказ
     */
    @NotNull
    private OutputUserDto user;

    /**
     * Список товаров в заказе
     */
    @NotNull
    private List<InputProductDto> products;

    /**
     * Время формирование заказа
     */
    @NotNull
    private Instant timeOfOrdering;

    /**
     * Стоимость заказа
     */
    @NotNull
    private BigDecimal cost;
}
