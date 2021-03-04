package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InputUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String password;
}
