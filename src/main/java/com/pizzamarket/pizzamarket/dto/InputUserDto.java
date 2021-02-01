package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InputUserDto {

    private String password;
    private String Name;
    private Integer phoneNumber;
}
