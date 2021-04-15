package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Маппер входного дто в заказ сущность
 */
@Component
public class DtoToOrderMapper implements Mapper<InputOrderDto, Order> {

    @Autowired
    private DtoToProductMapper dtoToProductMapper;

    @Override
    public Order convert(InputOrderDto pojo) {
        final Order order = new Order();

        order.setProducts(dtoToProductMapper.convertAll(pojo.getProducts()));

        return order;
    }
}
