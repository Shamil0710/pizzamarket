package com.pizzamarket.pizzamarket.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<F, T> {

    T convert(F pojo);

    default List<T> convertAll(List<F> pojos){
        return pojos.stream().map(this::convert).collect(Collectors.toList());
    }

}
