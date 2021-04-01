package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Дто для помещение в другие дто
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InternalUserDto {

    /**
     * Id пользователя
     */
    private Long id;

    /**
     * Номер телефона
     */
    @Size(min = 8, max = 8)
    @NotNull
    private String phoneNumber;

}
