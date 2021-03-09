package com.pizzamarket.pizzamarket.services.mappers;

public interface MapperEntity<T, F> {

    T toEntity(F dto);
}
