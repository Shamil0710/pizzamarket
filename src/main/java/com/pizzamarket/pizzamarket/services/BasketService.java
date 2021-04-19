package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.dto.InputProductDto;

/**
 * Интерфейс отвественный за работу с корзиной
 */
public interface BasketService {

    /**
     * Создание новой корзины
     *
     * @param basketDto дто корзины
     */
    void createBasket(BasketDto basketDto);

    /**
     * Добавление дто в карзину
     *
     * @param basketDto дто корзины
     */
    void addProductToBasket(BasketDto basketDto);

    /**
     * удаление товара из корзиты
     *
     * @param phoneNumber     номер телефона
     * @param inputProductDto дто товара
     */
    void deleteProductInBasket(String phoneNumber, InputProductDto inputProductDto);

    /**
     * Получение корзины по номеру телефона
     *
     * @param phoneNumber номер телефона
     * @return дто корзины
     */
    BasketDto getBasket(String phoneNumber);
}
