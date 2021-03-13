package com.pizzamarket.pizzamarket.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Исходящее дто пользователя
 */
@Getter
@AllArgsConstructor
public class OutputUserDto {

    /**
     * ID ользователя
     */
    @NotNull
    private Long id;

    /**
     * Имя пользователя
     */
    @NotNull
    private String firstName;

    /**
     * Фамилия пользователя
     */
    private String lastName;

    /**
     * Номер телефона
     */
    private Integer phoneNumber;

}
