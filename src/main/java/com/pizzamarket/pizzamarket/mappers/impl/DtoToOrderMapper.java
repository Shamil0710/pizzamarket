package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.services.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер входного дто в заказ сущность
 */
@Component
public class DtoToOrderMapper implements Mapper<InputOrderDto, Order> {

    @Override
    public Order convert(InputOrderDto pojo) {
        final Order order = new Order();

        order.setProducts(pojo.getProducts());

        return order;
    }
}
