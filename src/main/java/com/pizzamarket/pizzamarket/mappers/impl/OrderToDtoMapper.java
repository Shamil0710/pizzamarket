package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.mappers.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Преобразования сущности заказа в исходящее дто
 */
@Component
public class OrderToDtoMapper implements Mapper<Order, OutputOrderDto> {

    @Autowired
    UserToDtoMapper userToDtoMapper;

    @Autowired
    ProductToInputDtoMapper productToInputDtoMapper;

    @Override
    public OutputOrderDto convert(Order pojo) {
       return new OutputOrderDto(pojo.getId(), userToDtoMapper.convert(pojo.getUser()), productToInputDtoMapper.convertAll(pojo.getProducts()), pojo.getTimeOfOrdering(), pojo.getCost());
    }
}
