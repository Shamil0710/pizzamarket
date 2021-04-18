package com.pizzamarket.pizzamarket.mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Интерфейст ответсвеный за преобразование из одного класса в дрвугой
 * @param <F> Входящий обьект
 * @param <T> Исходящий обьект
 */
public interface Mapper<F, T> {

    /**
     * Конвертация одного обьекта
     * @param pojo Входящий обьект
     * @return Исходящий обьект
     */
    T convert(F pojo);

    /**
     * Конвертация коллекции
     * @param pojos Входящая коллекция
     * @return Исходящая коллекция
     */
    default List<T> convertAll(List<F> pojos){
        return pojos.stream().map(this::convert).collect(Collectors.toList());
    }

}
