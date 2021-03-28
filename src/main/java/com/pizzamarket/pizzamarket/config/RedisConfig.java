package com.pizzamarket.pizzamarket.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.TimeToLive;

/**
 * Конфигурации для редиса
 */
@Configuration
public class RedisConfig {

    //Префикс для подключения к редису
    public static final String REDIS_CONNECTION_PREFIX = "redis://";

    //ip адрес хоста
    @Value("${spring.redis.host}")
    private String redisHost;

    //Порт хоста
    @Value("${spring.redis.port}")
    private Integer redisPort;

    @TimeToLive
    @Value("${redis_ttl:3600000}")
    private Long TTL;

    /**
     * Предоставляет клиент редиса
     * @return
     */
    @Bean
    public RedisConnectionFactory redissonConnectionFactory(){
        return new RedissonConnectionFactory(redissonClient());
    }

    //Метод создания редис клиента
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {

        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_CONNECTION_PREFIX + redisHost + ":" + redisPort);

        return Redisson.create(config);
    }
}
