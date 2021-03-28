package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InternalUserDto {

    /**
     * Id пользователя
     */
    private Long id;

    /**
     * Имя пользователя
     */
    @NotNull
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @NotNull
    private String lastName;

    /**
     * Номер телефона
     */
    @Size(min = 8, max = 8)
    @NotNull
    private String phoneNumber;

}
