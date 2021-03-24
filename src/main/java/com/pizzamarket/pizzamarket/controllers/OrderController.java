package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import com.pizzamarket.pizzamarket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Класс для работы с заказами
 */
//todo: клменты, жавадок
@RestController(value = EndpointConstants.ORDER)
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * Метод создания заказа
     * @param phoneNumber
     */
    @PutMapping(value = EndpointConstants.ORDER_PUT_CREATE)
    void createOrder(@RequestBody String phoneNumber) {

        orderService.createOrder(phoneNumber);
    }

    /**
     * Метод удаления заказа по id
     * @param id
     */
    @DeleteMapping(value = EndpointConstants.ORDER_DELETE)
    void deleteById(@PathVariable Long id) {

        orderService.deleteById(id);
    }

    /**
     * Метод получение полного списка заказов
     * @return
     */
    @GetMapping(value = EndpointConstants.ORDER_GET_ALL)
    List<OutputOrderDto> getAll() {

       return orderService.getAll();
    }

    /**
     * Получение заказа по номеру телефона
     * @param phoneNumber
     * @return
     */
    @GetMapping(value = EndpointConstants.ORDER_GET_BY_PHONENUMBER)
    List<OutputOrderDto> getByPhoneNumber(@PathVariable String phoneNumber) {

        return orderService.findByPhoneNumber(phoneNumber);
    }


}
