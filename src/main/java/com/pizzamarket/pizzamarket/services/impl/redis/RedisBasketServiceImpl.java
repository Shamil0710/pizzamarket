package com.pizzamarket.pizzamarket.services.impl.redis;

import com.pizzamarket.pizzamarket.dto.BasketDto;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import com.pizzamarket.pizzamarket.mappers.impl.BasketToDto;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToBasket;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToProductMapper;
import com.pizzamarket.pizzamarket.services.ProductService;
import com.pizzamarket.pizzamarket.services.RedisBasketService;

import lombok.extern.slf4j.Slf4j;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class RedisBasketServiceImpl implements RedisBasketService {


    @Autowired
    RedissonClient redissonClient;

    @Autowired
    ProductService productService;

    @Autowired
    DtoToBasket dtoToBasket;

    @Autowired
    BasketToDto basketToDto;

    @Autowired
    DtoToProductMapper dtoToProductMapper;

    @Value("${redis_ttl:3600000}")
    private Long TTL;

    //Метод добавления корзин в редис
    @Override
    public <T>void setValue(@NotNull String key, T basket) {
        log.info("Добавлениие орзины по ключу " + key + "\n{}");

        final RBucket<Basket> bucket = redissonClient.getBucket(key);
        final long remainTime = bucket.remainTimeToLive();

        if (remainTime > 0) {
            bucket.set((Basket) basket, remainTime, TimeUnit.MILLISECONDS);
        } else {
            bucket.set((Basket) basket, remainTime, TimeUnit.SECONDS);
        }
    }

    //Метод удаления корзин из редиса
    @Override
    public void deleteKeyAndValue(@NotNull String key) {
        log.info("Удаление карзины по ключу " + key + "\n{}");

        redissonClient.getBucket(key).delete();
    }

    //Метод получения корзин из редиса
    @Override
    public <V>List<V> getList(@NotNull String key) {
        log.info("Получение карзины по ключу " + key + "\n{}");

        return (List<V>) redissonClient.getList(key).readAll();
    }

    //Получение и удаление по ключу
    @Override
    public BasketDto getBasket(@NotNull String key) {
        log.info("Получение и удаление карзины по ключу " + key + "\n{}");

        final RBucket<Basket> rBucket = redissonClient.getBucket(key);
        return basketToDto.convert(rBucket.getAndDelete());
    }

    //Добавление товара в корзину
    @Override
    public <V>void addToBasket(@NotNull String key, List<Product> product) {
        log.info("Добавление тоавра " + product.toString() + "в корзину по ключу " + key +"\n{}");

//        final RBucket<Basket> rBucket = redissonClient.getBucket(key);
        final long remainTime = redissonClient.getList(key).remainTimeToLive();

//        List<V> basketList = (List<V>) redissonClient.getList(key).add(product);
        redissonClient.getList(key).addAll(product);
        if (remainTime > 0) {
            redissonClient.getList(key).expire(remainTime, TimeUnit.MILLISECONDS);
        } else {
            redissonClient.getList(key).expire(TTL, TimeUnit.SECONDS);
        }
   }


}
