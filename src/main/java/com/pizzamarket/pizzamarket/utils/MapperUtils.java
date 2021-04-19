package com.pizzamarket.pizzamarket.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Класс для маппинга в json
 */
public class MapperUtils {

    public MapperUtils() {
        throw new IllegalStateException("Service mapper class!");
    }

    public static ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
    }
}

