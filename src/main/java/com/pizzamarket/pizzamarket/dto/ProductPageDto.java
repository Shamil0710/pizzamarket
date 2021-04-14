package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Класс запроса продуктов с пагинацией
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageDto {


    /**
     * номер страницы
     */
    @NotNull
    private Integer page;

    /**
     * кол-во итемов
     */
    @NotNull
    private Integer count;
}
