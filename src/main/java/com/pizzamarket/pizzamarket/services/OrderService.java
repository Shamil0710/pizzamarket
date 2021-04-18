package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;

import java.util.List;

public interface OrderService {

    void createOrder (String phoneNumber);

    void deleteById (Long id);

    List<OutputOrderDto> getAll ();

    List<OutputOrderDto> findByPhoneNumber (String phoneNumber);
}
