package com.pizzamarket.pizzamarket.services.impl;

import com.pizzamarket.pizzamarket.dto.InputOrderDto;
import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.dto.OutputOrderDto;
import com.pizzamarket.pizzamarket.entities.Order;
import com.pizzamarket.pizzamarket.repositorys.OrderRepository;
import com.pizzamarket.pizzamarket.repositorys.UserRepository;
import com.pizzamarket.pizzamarket.services.OrderService;
import com.pizzamarket.pizzamarket.services.UserService;

import com.pizzamarket.pizzamarket.services.mappers.imp.DtoToUserMapper;
import com.pizzamarket.pizzamarket.services.mappers.imp.OrderToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DtoToUserMapper dtoToUserMapper;

    @Autowired
    OrderToDtoMapper orderToDtoMapper;

    //TODO Это же не нарушение принципов?
    @Autowired
    UserService userService;

    @Override
    public Order createOrder(InputUserDto inputUserDto, InputOrderDto inputOrderDto) {
        Order order = new Order();

        order.setProducts(inputOrderDto.getProducts());
        order.setUser(userRepository.findById(inputUserDto.getId()).orElseThrow()); //TODO понять как посчитать сумму стримом


        return order;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void addProductToOder(InputOrderDto inputOrderDto) {
        orderRepository.findById(inputOrderDto.getId()).orElseThrow()
                .getProducts().addAll(inputOrderDto.getProducts());
        //TODO пересчитать стоимость заказа стримом
    }

    @Override
    public List<OutputOrderDto> getAll() {
        return orderToDtoMapper.convertAll(orderRepository.findAll());
    }

    @Override
    public List<OutputOrderDto> findByPhoneNumber(Integer phoneNumber) {
        return orderToDtoMapper.convertAll(orderRepository.findAllByUser_PhoneNumber(phoneNumber));
    }
}
