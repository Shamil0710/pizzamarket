package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.config.RedisConfig;
import com.pizzamarket.pizzamarket.entities.Basket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderController {

    @Autowired
    private RedisConfig redisConfig;

    private List<Basket> getAl() {

        redisConfig.redissonClient().
    }

}
