package com.pizzamarket.pizzamarket.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtils {

    public static ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
    }
}

