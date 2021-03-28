package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.dto.InputProductDto;


public interface BasketService {

    void createBasket(BasketDto basketDto);

    void addProductToBasket(BasketDto basketDto);

    void deleteProductInBasket(BasketDto basketDto, InputProductDto inputProductDto);

    BasketDto getBasket(String phoneNumber);

}
