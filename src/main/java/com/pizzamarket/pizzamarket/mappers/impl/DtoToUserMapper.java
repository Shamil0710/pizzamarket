package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер входного дто в сущность юсер
 */
@Component
public class DtoToUserMapper implements Mapper<InputUserDto, User> {

    @Override
    public User convert(InputUserDto pojo) {
        User user = new User();

        user.setLastName(pojo.getLastName());
        user.setFirstName(pojo.getFirstName());
        user.setPhoneNumber(pojo.getPhoneNumber());
        user.setPassword(pojo.getPassword());
        user.setId(pojo.getId());

        return user;
    }
}
