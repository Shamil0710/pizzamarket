package com.pizzamarket.pizzamarket.services.impl.redis;

import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.entities.redis.Basket;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToBasketMapper;
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

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class RedisBasketServiceImpl implements RedisBasketService {


    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ProductService productService;

    @Autowired
    private DtoToBasketMapper dtoToBasketMapper;

    @Autowired
    private DtoToProductMapper dtoToProductMapper;

    @Value("${redis_ttl:3600000}")
    private Long TTL;

    //Метод добавления корзин в редис
    @Override
    public <T> void setValue(@NotNull String key, T product) {
        log.info("Добавлениие орзины по ключу " + key + "\n{}");

        final RBucket<T> bucket = redissonClient.getBucket(key);
        final long remainTime = bucket.remainTimeToLive();

        if (remainTime > 0) {
            bucket.set(product, remainTime, TimeUnit.MILLISECONDS);
        } else {
            bucket.set(product, TTL, TimeUnit.MILLISECONDS);
        }
    }

    //Метод удаления корзин из редиса
    @Override
    public void deleteKeyAndValue(@NotNull String key) {
        log.info("Удаление карзины по ключу " + key + "\n{}");

        redissonClient.getBucket(key).delete();
    }

    //Метод получения корзин c листами из редиса
    @Override
    public <V> List<V> getList(@NotNull String key) {
        log.info("Получение карзины по ключу " + key + "\n{}");

        return (List<V>) redissonClient.getList(key).readAll();
    }

    //Метод получения корзин c листами из редиса и удаление корзины
    @Override
    public <V> List<V> getAndDeleteList(@NotNull String key) {
        log.info("Получение карзины по ключу " + key + " и удаление корзины" + "\n{}");

        List<V> productList = (List<V>) redissonClient.getList(key).readAll();

        redissonClient.getBucket(key).delete();

        return productList;
    }

    //Метод получения корзин c листами из редиса и удаление значение
    @Override
    public <V> void getListAndDeleteValue(@NotNull String key, V product) {
        log.info("Удаление из корзины по ключу " + key + " товара " + product.toString() + "\n{}");

        //TODO исправить, не работает

        List<V> productList = (List<V>) redissonClient.getList(key).readAll();

        redissonClient.getList(key).delete();

        productList.remove(product);

        redissonClient.getList(key).addAll(productList);

    }

    //Получение и удаление по ключу
    @Override
    public Basket getBasket(@NotNull String key) {
        log.info("Получение и удаление карзины по ключу " + key + "\n{}");

        final RBucket<Basket> rBucket = redissonClient.getBucket(key);

        return rBucket.get();
    }

    //Получение и удаление по ключу
    @Override
    public Basket getAndDeleteBasket(@NotNull String key) {
        log.info("Получение и удаление карзины по ключу " + key + "\n{}");

        final RBucket<Basket> rBucket = redissonClient.getBucket(key);

        return rBucket.getAndDelete();
    }

    //Добавление товара в корзину
    @Override
    public <V extends Serializable> void addToBasket(@NotNull String key, List<? extends V> product) {
        log.info("Добавление тоавра " + product.toString() + "в корзину по ключу " + key + "\n{}");

        final long remainTime = redissonClient.getList(key).remainTimeToLive();

            redissonClient.getList(key).addAll(product);

        if (remainTime > 0) {
            redissonClient.getList(key).expire(remainTime, TimeUnit.MILLISECONDS);
        } else {
            redissonClient.getList(key).expire(TTL, TimeUnit.MILLISECONDS);
        }
    }


}
