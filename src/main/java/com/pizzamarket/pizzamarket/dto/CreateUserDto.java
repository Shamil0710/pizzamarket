package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * дто пользователя с информацией необходимой для создание нового пользователя
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

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

    /**
     * Пароль
     */
    @NotNull
    private String password;

    /**
     * Уровень доступа пользователя
     */
    @NotNull
    private String role;
}

