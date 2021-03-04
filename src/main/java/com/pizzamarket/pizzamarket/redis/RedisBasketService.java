package com.pizzamarket.pizzamarket.redis;

import com.pizzamarket.pizzamarket.config.RedisConfig;
import com.pizzamarket.pizzamarket.entities.Basket;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class RedisBasketService {

    @Autowired
    RedisConfig redisConfig;

    @Value("${redis_ttl:3600000}")
    private Long TTL;

    //Метод добавления корзин в редис
public void setValue(@NotNull String key, @NotNull Basket basket) {
    //TODO чет хуета, спросить у ивана как он получал клиент
    final RBucket<Basket> bucket = redisConfig.redissonClient().getBucket(key);
    final long remainTime = bucket.remainTimeToLive();

    if(remainTime > 0) {
        bucket.set(basket, remainTime, TimeUnit.MILLISECONDS);
    }
    else {
        bucket.set(basket, remainTime, TimeUnit.SECONDS);
    }
}

    //Метод удаления корзин из редиса
public void deleteKeyAndValue(@NotNull String key) {
    redisConfig.redissonClient().getBucket(key).delete();
}

    //Метод получения корзин из редиса
public List<Basket> getList(@NotNull String key){
    return redisConfig.redissonClient().getList(key);
}

    //ПОлучение и удаление по ключу
public Basket getAndDelete(@NotNull String key) {
    final RBucket<Basket> rBucket = redisConfig.redissonClient().getBucket(key);
    return rBucket.getAndDelete();
}

}
