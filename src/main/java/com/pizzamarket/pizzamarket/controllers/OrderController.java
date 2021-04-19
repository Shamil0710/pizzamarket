package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import com.pizzamarket.pizzamarket.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Класс для работы с заказами
 */
@Slf4j
@RestController(value = EndpointConstants.ORDER)
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Метод создания заказа
     *
     * @param phoneNumber номер телефона
     */
    @PutMapping(value = EndpointConstants.ORDER_PUT_CREATE)
    void createOrder(@RequestParam String phoneNumber) {
        log.info("Создание корзины по номеру " + phoneNumber + "\n{}");

        orderService.createOrder(phoneNumber);
    }

    /**
     * Метод удаления заказа по id
     *
     * @param id id заказа
     */
    @PutMapping(value = EndpointConstants.ORDER_DELETE)
    void deleteById(@RequestParam Long id) {
        log.info("Удаление товара по id " + id.toString() + "\n{}");

        orderService.deleteById(id);
    }

    /**
     * Метод получение полного списка заказов
     *
     * @return
     */
    @GetMapping(value = EndpointConstants.ORDER_GET_ALL)
    List<OutputOrderDto> getAll() {
        log.info("Получение полного списка заказов");

        return orderService.getAll();
    }

    /**
     * Получение заказа по номеру телефона
     *
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(value = EndpointConstants.ORDER_GET_BY_PHONENUMBER)
    List<OutputOrderDto> getByPhoneNumber(@RequestParam String phoneNumber) {
        log.info("Получение заказа по номеру " + phoneNumber + "\n{}");

        return orderService.findByPhoneNumber(phoneNumber);
    }
}
