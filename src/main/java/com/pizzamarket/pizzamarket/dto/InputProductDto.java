package com.pizzamarket.pizzamarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class InputProductDto {

    private Long id;
    private BigDecimal cost;
    private String title;
    private String description;
    private String teg;
}
