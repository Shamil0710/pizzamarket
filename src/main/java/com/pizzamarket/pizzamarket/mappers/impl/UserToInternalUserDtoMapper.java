package com.pizzamarket.pizzamarket.mappers.impl;

import com.pizzamarket.pizzamarket.dto.InternalUserDto;
import com.pizzamarket.pizzamarket.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserToInternalUserDtoMapper implements com.pizzamarket.pizzamarket.services.mappers.Mapper<User, InternalUserDto> {

    @Override
    public InternalUserDto convert(User pojo) {
        return new InternalUserDto(pojo.getId(), pojo.getPhoneNumber());
    }
}
