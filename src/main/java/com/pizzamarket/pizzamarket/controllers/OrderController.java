package com.pizzamarket.pizzamarket.controllers;

import com.pizzamarket.pizzamarket.config.RedisConfig;
import com.pizzamarket.pizzamarket.entities.Basket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private RedisConfig redisConfig;

    private List<Basket> getAl() {

        redisConfig.redissonClient().
    }

}
