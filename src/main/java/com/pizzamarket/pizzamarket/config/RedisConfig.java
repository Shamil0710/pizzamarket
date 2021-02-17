package com.pizzamarket.pizzamarket.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    //Префикс для подключения к редису
    public static final String REDIS_CONNECTION_PREFIX = "redis://";

    //ip адрес хоста
    @Value("${spring.redis.host}")
    private String redisHost = "127.0.0.1";

    //Порт хоста
    @Value("${spring.redis.port}")
    private Integer redisPort = 6379;

//    @Bean
//    public RedisConnectionFactory redissonConnectionFactory(){
//        return new RedissonConnectionFactory(redissonClient());
//    }

    //Метод создания редис клиента
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {

        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_CONNECTION_PREFIX + redisHost + ":" + redisPort);

        return Redisson.create(config);
    }
}
