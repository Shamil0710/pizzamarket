package com.pizzamarket.pizzamarket.services.mappers.imp;

import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.services.mappers.Mapper;

/**
 * Преобразования сущности заказа в исходящее дто
 */
public class OrderToDtoMapper implements Mapper<Order, OutputOrderDto> {

    @Override
    public OutputOrderDto convert(Order pojo) {
       return new OutputOrderDto(pojo.getId(), pojo.getUser(), pojo.getProducts(), pojo.getTimeOfOrdering(), pojo.getCost());
    }
}
