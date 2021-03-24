package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.BasketDto;

import java.util.List;

public interface BasketService {

    void createBasket(String phoneNumber, BasketDto basketDto);

    void addProductToBasket(String phoneNumber, BasketDto basketDto);

    void deleteProductInBasket(String phoneNumber, BasketDto basketDto);

    BasketDto getBasket(String phoneNumber);

}
