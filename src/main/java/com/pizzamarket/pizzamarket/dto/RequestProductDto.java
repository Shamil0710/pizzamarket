package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Класс запроса продуктов с пагинацией и фильтрацией по тегу
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDto {

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

    /**
     * тэги для которых запрашиваются продукты
     */
    private List<String> tags;
}
