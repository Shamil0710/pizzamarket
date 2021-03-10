package com.pizzamarket.pizzamarket.services.redis;

import com.pizzamarket.pizzamarket.entities.Basket;
import com.pizzamarket.pizzamarket.services.RedisBasketService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class RedisBasketServiceImpl implements RedisBasketService {

    @Autowired
    RedissonClient redissonClient;

    @Value("${redis_ttl:3600000}")
    private Long TTL;

    //Метод добавления корзин в редис
    @Override
    public void setValue(@NotNull String key, @NotNull Basket basket) {
        final RBucket<Basket> bucket = redissonClient.getBucket(key);
        final long remainTime = bucket.remainTimeToLive();

        if (remainTime > 0) {
            bucket.set(basket, remainTime, TimeUnit.MILLISECONDS);
        } else {
            bucket.set(basket, remainTime, TimeUnit.SECONDS);
        }
    }

    //Метод удаления корзин из редиса
    @Override
    public void deleteKeyAndValue(@NotNull String key) {
        redissonClient.getBucket(key).delete();
    }

    //Метод получения корзин из редиса
    @Override
    public List<Basket> getList(@NotNull String key) {
        return redissonClient.getList(key);
    }

    //Получение и удаление по ключу
    @Override
    public Basket getAndDelete(@NotNull String key) {
        final RBucket<Basket> rBucket = redissonClient.getBucket(key);
        return rBucket.getAndDelete();
    }
}
