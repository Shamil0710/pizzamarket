package com.pizzamarket.pizzamarket.services.mappers.imp;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.services.mappers.Mapper;

/**
 * Маппер входного дто в заказ сущность
 */
public class DtoToOrderMapper implements Mapper<InputOrderDto, Order> {

    @Override
    public Order convert(InputOrderDto pojo) {
        final Order order = new Order();

        order.setProducts(pojo.getProducts());

        return order;
    }
}
