package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;

import java.util.List;

public interface OrderService {

    Order createOrder (InputUserDto inputUserDto, InputOrderDto inputOrderDto);

    void deleteById (Long id);

    void addProductToOder (InputOrderDto inputOrderDto);

    List<OutputOrderDto> getAll ();

    List<OutputOrderDto> findByPhoneNumber (Integer phoneNumber);
}
