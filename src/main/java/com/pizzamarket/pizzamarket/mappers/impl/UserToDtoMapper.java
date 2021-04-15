package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.OutputUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import com.pizzamarket.pizzamarket.mappers.Mapper;
import org.springframework.stereotype.Component;

/**
 * Маппер сущности юсер в исходящее дто
 */
@Component
public class UserToDtoMapper implements Mapper<User, OutputUserDto> {
    @Override
    public OutputUserDto convert(User pojo) {
        return new OutputUserDto(pojo.getId(), pojo.getFirstName(), pojo.getLastName(), pojo.getPhoneNumber());
    }
}
