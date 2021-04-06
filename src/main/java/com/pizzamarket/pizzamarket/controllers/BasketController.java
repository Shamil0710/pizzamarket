package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.constants.EndpointConstants;
import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.dto.InputProductDto;
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
    private BasketService basketService;


    /**
     * Метод для создания новой карзины
     *
     * @param basketDto дто корзины
     */
    @PutMapping(value = EndpointConstants.BASKET_PUT_CREATE)
    void createBasket(@RequestBody BasketDto basketDto) {
        log.info("Создание новой корзины");

        basketService.createBasket(basketDto);
    }

    /**
     * Метод добавления товара в корзины
     *
     * @param basketDto дто корзины
     */
    @PutMapping(value = EndpointConstants.BASKET_PUT_ADD_TO_BASKET)
    void addProductToBasket(@RequestBody BasketDto basketDto) {
        log.info("Обновление информации о продукте");

        basketService.addProductToBasket(basketDto);
    }

    /**
     * Метод удаления товара из корзины
     *
     * @param basketDto
     */
    @DeleteMapping(value = EndpointConstants.BASKET_DELETE_PRODUCT_IN_BASKET)
    void deleteProductInBasket(@RequestBody BasketDto basketDto, @RequestBody InputProductDto inputProductDto) {
        log.info("Удаление продукта из корзины с номером " + basketDto.getPhoneNumber() + "\n{}");

        basketService.deleteProductInBasket(basketDto, inputProductDto);
    }

    /**
     * Метод получение корзины по номеру телефона
     *
     * @param phoneNumber номер телефона
     * @return
     */
    @GetMapping(value = EndpointConstants.BASKET_GET_BASKET)
    BasketDto getBasket(@RequestBody String phoneNumber) {
        log.info("Получение корзины по номеру " + phoneNumber + "\n{}");

        return basketService.getBasket(phoneNumber);
    }
}
