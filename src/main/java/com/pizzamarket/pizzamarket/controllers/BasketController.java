package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.services.BasketService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Контроллер для работы с корзинами
 */
@Slf4j
@RestController(value = EndpointConstants.BASKET)
public class BasketController {

    @Autowired
    BasketService basketService;


//    @PutMapping(value = EndpointConstants.ORDER_PUT_CREATE)
//    void createOrder(@RequestBody String phoneNumber) {
//
//        orderService.createOrder(phoneNumber);
//    }

    /**
     * Метод для создания новой карзины
     * @param phoneNumber Номер телефона
     * @param basketDto дто корзины
     */
    @PutMapping(value = EndpointConstants.BASKET_PUT_CREATE)
    void createBasket(@RequestBody String phoneNumber, @RequestBody BasketDto basketDto) {

        basketService.createBasket(phoneNumber, basketDto);
    }

    /**
     * Метод добавления товара в корзины
     * @param phoneNumber Номер телефона
     * @param basketDto дто корзины
     */
    @PutMapping(value = EndpointConstants.BASKET_PUT_ADD_TO_BASKET)
    void addProductToBasket(@RequestBody String phoneNumber, @RequestBody BasketDto basketDto) {

        basketService.addProductToBasket(phoneNumber, basketDto);
    }

    /**
     * Метод удаления товара из корзины
     * @param phoneNumber
     * @param basketDto
     */
    @DeleteMapping(value = EndpointConstants.BASKET_DELETE_PRODUCT_IN_BASKET)
    void deleteProductInBasket(@RequestBody String phoneNumber, @RequestBody BasketDto basketDto) {
        //TODO еализовать ЭТО
    }

    /**
     * Метод получение корзины по номеру телефона
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(value = EndpointConstants.BASKET_GET_BASKET)
    BasketDto getBasket(@RequestBody String phoneNumber) {

        return basketService.getBasket(phoneNumber);
    }
}
