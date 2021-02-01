package com.pizzamarket.pizzamarket.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OutputUserDto {

    private Long id;
    private String Name;
    private Integer phoneNumber;
}
