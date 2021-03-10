package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.entities.Basket;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface RedisBasketService {
    //Метод добавления корзин в редис
    void setValue(@NotNull String key, @NotNull Basket basket);

    //Метод удаления корзин из редиса
    void deleteKeyAndValue(@NotNull String key);

    //Метод получения корзин из редиса
    List<Basket> getList(@NotNull String key);

    //Получение и удаление по ключу
    Basket getAndDelete(@NotNull String key);
}
