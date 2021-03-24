package com.pizzamarket.pizzamarket.services.impl;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.mappers.impl.BasketToDto;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToBasket;
import com.pizzamarket.pizzamarket.services.BasketService;
import com.pizzamarket.pizzamarket.services.RedisBasketService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы
 */
@Slf4j
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    RedisBasketService redisBasketService;

    @Autowired
    DtoToBasket dtoToBasket;

    @Autowired
    BasketToDto basketToDto;


    /**
     * Метод создания новой корзины
     * @param phoneNumber
     * @param basketDto
     */
    @Override
    public void createBasket(String phoneNumber, BasketDto basketDto) {
        log.info("Создание коризны по номеру " + phoneNumber + "С товарами" + basketDto.getProducts().toString() + "\n{}");

        redisBasketService.setValue(phoneNumber, dtoToBasket.convert(basketDto));
    }

    /**
     * Добавление товара в корзину
     * @param phoneNumber
     * @param basketDto
     */
    @Override
    public void addProductToBasket(String phoneNumber, BasketDto basketDto) {
        log.info("Добавление в коризну по номеру " + phoneNumber + "товара " + basketDto.getProducts().toString() + "\n{}");

        redisBasketService.addToBasket(phoneNumber, dtoToBasket.convert(basketDto).getProducts());
    }

    /**
     * Метод удаление конкретного продукта из корзины
     * @param phoneNumber
     * @param basketDto
     */
    @Override
    public void deleteProductInBasket(String phoneNumber, BasketDto basketDto) {
//TODO ПРидумать реализацию
    }

    /**
     * Метод получение корзины по номеру телефона
     * @param phoneNumber
     * @return
     */
    @Override
    public BasketDto getBasket(String phoneNumber) {
        BasketDto basketDto = new BasketDto(redisBasketService.getBasket(phoneNumber).getProducts());

        return basketDto;
    }
}
