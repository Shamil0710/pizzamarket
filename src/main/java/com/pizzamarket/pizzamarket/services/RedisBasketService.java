package com.pizzamarket.pizzamarket.services;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.entities.redis.Basket;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface RedisBasketService {
    //Метод добавления корзин в редис
    <T>void setValue(@NotNull String key, T basket);

    //Метод удаления корзин из редиса
    void deleteKeyAndValue(@NotNull String key);

    //Метод получения корзин из редиса
    <V>List<V> getList(@NotNull String key);

    //Получение и удаление по ключу
    Basket getBasket(@NotNull String key);

    //Добавление товара в корзну
    <V extends Serializable> void addToBasket(@NotNull String key, List<? extends V> product);

    //Получение и удаление корзины
    Basket getAndDeleteBasket(@NotNull String key);

    //Получение листа продуктов и удлаение корзины
    <V> List<V> getAndDeleteList(@NotNull String key);

    //Метод получения корзин c листами из редиса и удаление значение
    <V> void getListAndDeleteValue(@NotNull String key, V product);
}
