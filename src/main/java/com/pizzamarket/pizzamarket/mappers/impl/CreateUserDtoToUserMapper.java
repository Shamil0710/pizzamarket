package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.CreateUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.stereotype.Component;

/**
 * Метод преобразования дто для создания нового пользователя в сущность, без присвоение id
 */
@Component
public class CreateUserDtoToUserMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<CreateUserDto, User> {
    @Override
    public User convert(CreateUserDto pojo) {
        final User user = new User();

        user.setPassword(pojo.getPassword());
        user.setLastName(pojo.getLastName());
        user.setFirstName(pojo.getFirstName());
        user.setPhoneNumber(user.getPhoneNumber());

        return user;
    }
}
