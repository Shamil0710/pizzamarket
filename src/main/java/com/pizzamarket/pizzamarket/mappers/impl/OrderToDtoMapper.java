package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.services.mappers.Mapper;

import org.springframework.stereotype.Component;

/**
 * Преобразования сущности заказа в исходящее дто
 */
@Component
public class OrderToDtoMapper implements Mapper<Order, OutputOrderDto> {

    @Override
    public OutputOrderDto convert(Order pojo) {
       return new OutputOrderDto(pojo.getId(), pojo.getUser(), pojo.getProducts(), pojo.getTimeOfOrdering(), pojo.getCost());
    }
}
