package com.pizzamarket.pizzamarket.services.mappers;

public interface MapperDto<T, F> {

   T toDto(F entity);

}
