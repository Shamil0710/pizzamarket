package com.pizzamarket.pizzamarket.services.impl;

import com.pizzamarket.pizzamarket.Exceptions.UserNotFoundException;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.entities.Product;
import com.pizzamarket.pizzamarket.mappers.impl.DtoToUserMapper;
import com.pizzamarket.pizzamarket.mappers.impl.OrderToDtoMapper;
import com.pizzamarket.pizzamarket.repositorys.OrderRepository;
import com.pizzamarket.pizzamarket.repositorys.UserRepository;
import com.pizzamarket.pizzamarket.services.OrderService;
import com.pizzamarket.pizzamarket.services.RedisBasketService;
import com.pizzamarket.pizzamarket.services.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


/**
 * Сервис для работы с заказами
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisBasketService redisBasketService;

    @Autowired
    DtoToUserMapper dtoToUserMapper;

    @Autowired
    OrderToDtoMapper orderToDtoMapper;

    @Autowired
    UserService userService;

    /**
     * Метод создания нового заказа
     * @param phoneNumber
     */
    @Override
    public void createOrder(String phoneNumber) {
        log.info("Создание ноового заказа \n");

        Order order = new Order();

        order.setProducts(redisBasketService.getBasket(phoneNumber).getProducts());
        order.setUser(userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UserNotFoundException(
                String.format("Пользователь с номером телефонв %s не найден", phoneNumber))));
        order.setTimeOfOrdering(Instant.now());
        order.setCost(redisBasketService.getBasket(phoneNumber).getProducts()
                .stream().map(Product::getCost)
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new IllegalArgumentException("Некоректное значение стоимости")));

        orderRepository.save(order);
    }

    /**
     * Удаление заказа по id
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        log.info("Удаление заказа по id " + id.toString() + "\n{}");

        orderRepository.deleteById(id);
    }

//    @Override
//    public void addProductToOder(InputOrderDto inputOrderDto) {
//        orderRepository.findById(inputOrderDto.getId()).orElseThrow(() -> new IllegalArgumentException("Некоректное значение стоимости"))
//                .getProducts().addAll(inputOrderDto.getProducts());
//        //TODO пересчитать стоимость заказа стримом
//    }

    /**
     * Получение полного списка заказов
     * @return
     */
    @Override
    public List<OutputOrderDto> getAll() {
        log.info("Получение полного списка заказов");

        return orderToDtoMapper.convertAll(orderRepository.findAll());
    }

    /**
     * Получение заказов по нормеру телефона
     * @param phoneNumber
     * @return
     */
    @Override
    public List<OutputOrderDto> findByPhoneNumber(String phoneNumber) {
        log.info("Получение списка заказов по номнру телефона " + phoneNumber.toString() + "\n{}");

        return orderToDtoMapper.convertAll(orderRepository.findAllByUser_PhoneNumber(phoneNumber));
    }
}
